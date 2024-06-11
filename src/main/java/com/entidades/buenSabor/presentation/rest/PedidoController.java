package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.PedidoFacadeImp;
import com.entidades.buenSabor.domain.dto.pais.PaisFullDto;
import com.entidades.buenSabor.business.facade.PedidoFacade;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.dto.pedido.PedidoFullDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Estado;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin("*")
public class PedidoController extends BaseControllerImp<Pedido, PedidoFullDto, Long, PedidoFacadeImp> {

    @Autowired
    private PedidoFacade pedidoFacade;

    public PedidoController(PedidoFacadeImp facade) {super (facade); }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PedidoFullDto>> getPedidosByCliente(@PathVariable Long clienteId) {
        List<PedidoFullDto> pedidos = pedidoFacade.findByClienteId(clienteId);
        if (pedidos != null && !pedidos.isEmpty()) {
            return ResponseEntity.ok(pedidos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoFullDto> getById(@PathVariable Long id){
        return super.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<PedidoFullDto>> getAll() {
        return super.getAll();
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PedidoFullDto> create(@RequestBody PedidoFullDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PedidoFullDto> edit(@RequestBody PedidoFullDto entity, @PathVariable Long id){
        return super.edit(entity, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }

    @GetMapping("ranking/insumos/excel")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<byte[]> downloadRankingInsumosExcel(@RequestParam("desde") Instant desde, @RequestParam("hasta") Instant hasta) throws SQLException {
        try {
            SXSSFWorkbook libroExcel = this.facade.getRankingInsumo(desde, hasta);
            // Escribir el libro de trabajo en un flujo de bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            libroExcel.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "datos.xlsx");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("ranking/pedidos/cliente/excel")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<byte[]> downloadCantidadPedidosPorClienteExcel(@RequestParam("desde") Instant desde, @RequestParam("hasta") Instant hasta) throws SQLException {
        try {
            SXSSFWorkbook libroExcel = this.facade.getCantidadDePedidosPorCliente(desde, hasta);
            // Escribir el libro de trabajo en un flujo de bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            libroExcel.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "datos.xlsx");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("ranking/ingresos/excel")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<byte[]> downloadIngresosExcel(@RequestParam("desde") Instant desde, @RequestParam("hasta") Instant hasta) throws SQLException {
        try {
            SXSSFWorkbook libroExcel = this.facade.getIngresos(desde, hasta);
            // Escribir el libro de trabajo en un flujo de bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            libroExcel.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "datos.xlsx");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("ranking/ganancias/excel")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<byte[]> downloadGananciasExcel(@RequestParam("desde") Instant desde, @RequestParam("hasta") Instant hasta) throws SQLException {
        try {
            SXSSFWorkbook libroExcel = this.facade.getGanancias(desde, hasta);
            // Escribir el libro de trabajo en un flujo de bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            libroExcel.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "datos.xlsx");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{pedidoId}/estado")
    @PreAuthorize("hasAnyAuthority('CAJERO', 'ADMIN', 'COCINERO')")
    public ResponseEntity<Pedido> cambiarEstadoPedido(
            @PathVariable Long pedidoId,
            @RequestParam Estado nuevoEstado
    ) {
        Pedido pedidoActualizado = this.facade.cambiarEstado(pedidoId, nuevoEstado);
        return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
    }

}
