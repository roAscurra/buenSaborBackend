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
    public PedidoFacadeImp(BaseService<Pedido, Long> baseService, BaseMapper<Pedido, PedidoFullDto> baseMapper, PedidoService pedidoService) {
        super(baseService, baseMapper);
        this.pedidoService = pedidoService;
    }

    public SXSSFWorkbook getRankingInsumo(Instant desde, Instant hasta) {

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
        List<Object[]> rankingArticulos = this.pedidoService.getRankingInsumo(desde, hasta);
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

    public SXSSFWorkbook getCantidadDePedidosPorCliente(Instant desde, Instant hasta) {

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
        List<Object[]> rankingArticulos = this.pedidoService.getCantidadPedidosPorCliente(desde, hasta);
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

    public SXSSFWorkbook getIngresos(Instant desde, Instant hasta) {

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
        List<Object[]> rankingArticulos = this.pedidoService.getIngresos(desde, hasta);
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

    public SXSSFWorkbook getGanancias(Instant desde, Instant hasta) {

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
        List<Object[]> rankingArticulos = this.pedidoService.getGanancias(desde, hasta);
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
}
