package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.PedidoFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.dto.pedido.PedidoFullDto;
import com.entidades.buenSabor.domain.entities.Articulo;
import com.entidades.buenSabor.domain.entities.Cliente;
import com.entidades.buenSabor.domain.entities.DetallePedido;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Estado;
import com.entidades.buenSabor.domain.enums.Rol;
import com.entidades.buenSabor.repositories.PedidoRepository;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoFacadeImp extends BaseFacadeImp<Pedido, PedidoFullDto, Long> implements PedidoFacade {
    @Autowired

    private PedidoService pedidoService;
    public List<PedidoFullDto> findByClienteId(Long idCliente) {
        return this.pedidoService.findByClienteId(idCliente);
    }
    public List<PedidoFullDto> pedidosSucursal(Long idSucursal) {
        return this.pedidoService.pedidosSucursal(idSucursal);
    }
    public PedidoFacadeImp(BaseService<Pedido, Long> baseService, BaseMapper<Pedido, PedidoFullDto> baseMapper, PedidoService pedidoService) {
        super(baseService, baseMapper);
        this.pedidoService = pedidoService;
    }

    public List<Object[]> getRankingInsumoData(Long sucursalId) {
        return this.pedidoService.getRankingInsumo(sucursalId)
                .stream().map((value) -> new Object[]{((Articulo) value[0]).getDenominacion(), value[1]})
                .toList();
    }

    public SXSSFWorkbook getRankingInsumo(Long sucursalId, Instant desde, Instant hasta) {

        // Se crea el libro
        SXSSFWorkbook libro = new SXSSFWorkbook(50); //importante !! el 50 indica el tamaño de paginación
        // Se crea una hoja dentro del libro
        SXSSFSheet hoja = libro.createSheet();
        //estilo
        XSSFFont font = (XSSFFont) libro.createFont();
        font.setBold(true);
        XSSFCellStyle style = (XSSFCellStyle) libro.createCellStyle();
        style.setFont(font);
        int nroColumna = 0;
        // Se crea una fila dentro de la hoja
        SXSSFRow row = hoja.createRow(0);
        // Se crea una celda dentro de la fila
        SXSSFCell cell = row.createCell(nroColumna);
        cell.setCellValue("Articulo");
        cell.setCellStyle(style);
        cell = row.createCell(++nroColumna);
        cell.setCellValue("Cantidad");
        cell.setCellStyle(style);

        int nroFila = 1;
        nroColumna = 0;
        List<Object[]> rankingArticulos = this.pedidoService.getRankingInsumo(sucursalId, desde, hasta);
        if(rankingArticulos != null){
            for (Object[] object : rankingArticulos) {
                nroColumna = 0;
                row = hoja.createRow(nroFila);
                ++nroFila;
                cell = row.createCell(nroColumna);
                cell.setCellValue(((Articulo) object[0]).getDenominacion());
                cell = row.createCell(++nroColumna);
                cell.setCellValue(((Long)object[1]));
            }
        }
        return libro;
    }

    public List<Object[]> getCantidadDePedidosPorData(Long sucursalId) {
        return this.pedidoService.getCantidadPedidosPorCliente(sucursalId);
    }

    public SXSSFWorkbook getCantidadDePedidosPorCliente(Long sucursalId, Instant desde, Instant hasta) {

        // Se crea el libro
        SXSSFWorkbook libro = new SXSSFWorkbook(50); //importante !! el 50 indica el tamaño de paginación
        // Se crea una hoja dentro del libro
        SXSSFSheet hoja = libro.createSheet();
        //estilo
        XSSFFont font = (XSSFFont) libro.createFont();
        font.setBold(true);
        XSSFCellStyle style = (XSSFCellStyle) libro.createCellStyle();
        style.setFont(font);
        int nroColumna = 0;
        // Se crea una fila dentro de la hoja
        SXSSFRow row = hoja.createRow(0);
        // Se crea una celda dentro de la fila
        SXSSFCell cell = row.createCell(nroColumna);
        cell.setCellValue("EmailCliente");
        cell.setCellStyle(style);
        cell = row.createCell(++nroColumna);
        cell.setCellValue("Cantidad");
        cell.setCellStyle(style);

        int nroFila = 1;
        nroColumna = 0;
        List<Object[]> rankingArticulos = this.pedidoService.getCantidadPedidosPorCliente(sucursalId, desde, hasta);
        if(rankingArticulos != null){
            for (Object[] object : rankingArticulos) {
                nroColumna = 0;
                row = hoja.createRow(nroFila);
                ++nroFila;
                cell = row.createCell(nroColumna);
                cell.setCellValue(((String) object[0]));
                cell = row.createCell(++nroColumna);
                cell.setCellValue(((Long)object[1]));
            }
        }
        return libro;
    }

    public List<Object[]> getIngresosData(Long sucursalId) {
        return this.pedidoService.getIngresos(sucursalId);
    }

    public SXSSFWorkbook getIngresos(Long sucursalId, Instant desde, Instant hasta) {

        // Se crea el libro
        SXSSFWorkbook libro = new SXSSFWorkbook(50); //importante !! el 50 indica el tamaño de paginación
        // Se crea una hoja dentro del libro
        SXSSFSheet hoja = libro.createSheet();
        //estilo
        XSSFFont font = (XSSFFont) libro.createFont();
        font.setBold(true);
        XSSFCellStyle style = (XSSFCellStyle) libro.createCellStyle();
        style.setFont(font);
        int nroColumna = 0;
        // Se crea una fila dentro de la hoja
        SXSSFRow row = hoja.createRow(0);
        // Se crea una celda dentro de la fila
        SXSSFCell cell = row.createCell(nroColumna);
        cell.setCellValue("Fecha");
        cell.setCellStyle(style);
        cell = row.createCell(++nroColumna);
        cell.setCellValue("Cantidad");
        cell.setCellStyle(style);

        int nroFila = 1;
        nroColumna = 0;
        List<Object[]> rankingArticulos = this.pedidoService.getIngresos(sucursalId, desde, hasta);
        if(rankingArticulos != null){
            for (Object[] object : rankingArticulos) {
                nroColumna = 0;
                row = hoja.createRow(nroFila);
                ++nroFila;
                cell = row.createCell(nroColumna);
                cell.setCellValue(((String) object[0]));
                cell = row.createCell(++nroColumna);
                cell.setCellValue(((Double)object[1]));
            }
        }
        return libro;
    }

    public List<Object[]> getGananciasData(Long sucursalId) {
        return this.pedidoService.getGanancias(sucursalId);
    }

    public SXSSFWorkbook getGanancias(Long sucursalId, Instant desde, Instant hasta) {

        // Se crea el libro
        SXSSFWorkbook libro = new SXSSFWorkbook(50); //importante !! el 50 indica el tamaño de paginación
        // Se crea una hoja dentro del libro
        SXSSFSheet hoja = libro.createSheet();
        //estilo
        XSSFFont font = (XSSFFont) libro.createFont();
        font.setBold(true);
        XSSFCellStyle style = (XSSFCellStyle) libro.createCellStyle();
        style.setFont(font);
        int nroColumna = 0;
        // Se crea una fila dentro de la hoja
        SXSSFRow row = hoja.createRow(0);
        // Se crea una celda dentro de la fila
        SXSSFCell cell = row.createCell(nroColumna);
        cell.setCellValue("Fecha");
        cell.setCellStyle(style);
        cell = row.createCell(++nroColumna);
        cell.setCellValue("Ganancia");
        cell.setCellStyle(style);

        int nroFila = 1;
        nroColumna = 0;
        List<Object[]> rankingArticulos = this.pedidoService.getGanancias(sucursalId, desde, hasta);
        if(rankingArticulos != null){
            for (Object[] object : rankingArticulos) {
                nroColumna = 0;
                row = hoja.createRow(nroFila);
                ++nroFila;
                cell = row.createCell(nroColumna);
                cell.setCellValue(((String) object[0]));
                cell = row.createCell(++nroColumna);
                cell.setCellValue(((Double)object[1]));
            }
        }
        return libro;
    }

    @Override
    public Pedido cambiarEstado(Long pedidoId, Estado nuevoEstado) {
        return pedidoService.cambiarEstado(pedidoId, nuevoEstado);
    }

    @Override
    public List<Pedido> getPedidosFiltrados(String rol) {
        return pedidoService.getPedidosFiltrados(rol);
    }


}
