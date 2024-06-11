package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.mapper.PedidoMapper;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.dto.pedido.PedidoFullDto;
import com.entidades.buenSabor.domain.entities.*;
import com.entidades.buenSabor.domain.enums.Estado;
import com.entidades.buenSabor.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PedidoServiceImp extends BaseServiceImp<Pedido, Long> implements PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    DetallePedidoRepository detallePedidoRepository;

    @Autowired
    ArticuloRepository articuloRepository;

    @Autowired
    SucursalRepository sucursalRepository;

    @Autowired
    DomicilioRepository domicilioRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    public List<PedidoFullDto> findByClienteId(Long clienteId) {
        List<Pedido> pedidos = this.pedidoRepository.findByClienteId(clienteId);
        return pedidoMapper.pedidosToPedidoFullDtos(pedidos);
    }

    @Override
    public Pedido create(Pedido request) {
        if (request.getSucursal() == null) {
            throw new RuntimeException("No se ha asignado una sucursal al pedido");
        }
        Sucursal sucursal = sucursalRepository.findById(request.getSucursal().getId())
                .orElseThrow(() -> new RuntimeException("La sucursal con id " + request.getSucursal().getId() + " no se ha encontrado"));

        var domicilio = request.getDomicilio();
        if(domicilio != null){
            domicilio = domicilioRepository.save(domicilio);
        }

        Set<DetallePedido> detalles = request.getDetallePedidos();
        Set<DetallePedido> detallesPersistidos = new HashSet<>();

        if (detalles != null && !detalles.isEmpty()) {
            double costoTotal = 0;
            for (DetallePedido detalle : detalles) {
                Articulo articulo = detalle.getArticulo();
                if (articulo == null || articulo.getId() == null) {
                    throw new RuntimeException("El artículo del detalle no puede ser nulo.");
                }
                articulo = articuloRepository.findById(detalle.getArticulo().getId())
                        .orElseThrow(() -> new RuntimeException("Artículo con id " + detalle.getArticulo().getId() + " inexistente"));
                detalle.setArticulo(articulo);
                DetallePedido savedDetalle = detallePedidoRepository.save(detalle);
                costoTotal += calcularTotalCosto(articulo, detalle.getCantidad());
                descontarStock(articulo, detalle.getCantidad());
                detallesPersistidos.add(savedDetalle);
            }
            request.setTotalCosto(costoTotal);
            request.setDetallePedidos(detallesPersistidos);
        } else {
            throw new IllegalArgumentException("El pedido debe contener un detalle o más.");
        }

        request.setDomicilio(domicilio);
        request.setSucursal(sucursal);
        request.setFechaPedido(LocalDate.now());

        return pedidoRepository.save(request);
    }

    @Transactional
    public Articulo descontarStock(Articulo articulo, int cantidad) {
        if (articulo instanceof ArticuloInsumo) {

            ArticuloInsumo insumo = (ArticuloInsumo) articulo;
            System.out.println("Stock antes de descontar: " + insumo.getStockActual());
            int stockDescontado = insumo.getStockActual() - cantidad; // Descontar cantidad a stock actual
            System.out.println("Stock después de restarle la cantidad: " + stockDescontado);

            // Validar que el stock actual no supere el mínimo
            if (stockDescontado <= insumo.getStockMinimo()) {
                throw new RuntimeException("El insumo " + insumo.getDenominacion() + " alcanzó el stock mínimo: " + stockDescontado);
            }

            // Asignarle al insumo
            insumo.setStockActual(stockDescontado);
            return insumo; // Return the updated insumo

        } else if (articulo instanceof ArticuloManufacturado) {
            // Cast the articulo to ArticuloManufacturado
            ArticuloManufacturado manufacturado = (ArticuloManufacturado) articulo;
            // Obtener los detalles del manufacturado
            Set<ArticuloManufacturadoDetalle> detalles = manufacturado.getArticuloManufacturadoDetalles();

            if (detalles != null && !detalles.isEmpty()) {
                for (ArticuloManufacturadoDetalle detalle : detalles) {
                    ArticuloInsumo insumo = detalle.getArticuloInsumo();
                    // Cantidad necesaria de insumo por la cantidad de manufacturados del pedido
                    int cantidadInsumo = detalle.getCantidad() * cantidad;
                    // Descontar el stock actual
                    int stockDescontado = insumo.getStockActual() - cantidadInsumo;
                    if (stockDescontado <= insumo.getStockMinimo()) {
                        throw new RuntimeException("El insumo con id " + insumo.getId() + " (" + insumo.getDenominacion() + ") presente en el artículo "
                                + manufacturado.getDenominacion() + " (id " + manufacturado.getId() + ") alcanzó el stock mínimo: " + stockDescontado);
                    }
                    insumo.setStockActual(stockDescontado); // Asignarle al insumo, el stock descontado
                }
            }
            return manufacturado; // Return the updated manufacturado
        } else {
            // Por si no encuentra el artículo o es de un tipo desconocido
            throw new RuntimeException("Artículo de tipo desconocido con id " + articulo.getId());
        }
    }

    public Double calcularTotalCosto(Articulo articulo, Integer cantidad) {
        if (articulo instanceof ArticuloInsumo) { // verifico si es articuloInsumo
            ArticuloInsumo insumo = (ArticuloInsumo) articulo;
            return insumo.getPrecioCompra() * cantidad;
        } else if (articulo instanceof ArticuloManufacturado) { //verifico si es articuloManufacturado
            ArticuloManufacturado manufacturado = (ArticuloManufacturado) articulo;
            Set<ArticuloManufacturadoDetalle> detalles = manufacturado.getArticuloManufacturadoDetalles();

            if (detalles != null && !detalles.isEmpty()) {
                double totalCosto = 0;
                for (ArticuloManufacturadoDetalle detalle : detalles) {
                    double precioCompraInsumo = detalle.getArticuloInsumo().getPrecioCompra();
                    double cantidadInsumo = detalle.getCantidad();
                    totalCosto += (precioCompraInsumo * cantidadInsumo);
                }
                // Multiplicar por la cantidad de artículos manufacturados
                return totalCosto * cantidad;
            }
        }
        return 0.0;
    }

    @Override
    public List<Object[]> getRankingInsumo(Instant desde, Instant hasta) {
        ZoneId zoneId = ZoneId.systemDefault();

        return pedidoRepository.getRankingInsumos(ZonedDateTime.ofInstant(desde, zoneId).toLocalDate(), ZonedDateTime.ofInstant(hasta, zoneId).toLocalDate());
    }

    @Override
    public List<Object[]> getCantidadPedidosPorCliente(Instant desde, Instant hasta) {
        ZoneId zoneId = ZoneId.systemDefault();

        return pedidoRepository.getCantidadPedidosPorCliente(ZonedDateTime.ofInstant(desde, zoneId).toLocalDate(), ZonedDateTime.ofInstant(hasta, zoneId).toLocalDate());
    }

    @Override
    public List<Object[]> getIngresos(Instant desde, Instant hasta) {
        ZoneId zoneId = ZoneId.systemDefault();

        return pedidoRepository.getIngresos(ZonedDateTime.ofInstant(desde, zoneId).toLocalDate(), ZonedDateTime.ofInstant(hasta, zoneId).toLocalDate());
    }

    @Override
    public List<Object[]> getGanancias(Instant desde, Instant hasta) {
        ZoneId zoneId = ZoneId.systemDefault();

        return pedidoRepository.getGanancias(ZonedDateTime.ofInstant(desde, zoneId).toLocalDate(), ZonedDateTime.ofInstant(hasta, zoneId).toLocalDate());
    }

    @Override
    public Pedido cambiarEstado(Long pedidoId, Estado nuevoEstado) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
        pedido.setEstado(nuevoEstado);
        return pedidoRepository.save(pedido);
    }
}
