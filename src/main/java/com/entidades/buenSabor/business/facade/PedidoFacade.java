package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.pedido.PedidoFullDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Estado;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.time.Instant;
import java.util.List;

public interface PedidoFacade extends BaseFacade<PedidoFullDto, Long> {

    SXSSFWorkbook getRankingInsumo(Instant desde, Instant hasta);

    List<Object[]> getRankingInsumoData();

    List<Object[]> getCantidadDePedidosPorData();

    List<Object[]> getIngresosData();

    List<Object[]> getGananciasData();

    SXSSFWorkbook getCantidadDePedidosPorCliente(Instant desde, Instant hasta);

    Pedido cambiarEstado(Long pedidoId, Estado nuevoEstado);
    List<Pedido> getPedidosFiltrados(String rol);

    List<PedidoFullDto> findByClienteId(Long clienteId);

}
