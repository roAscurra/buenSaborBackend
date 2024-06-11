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

    SXSSFWorkbook getCantidadDePedidosPorCliente(Instant desde, Instant hasta);

    Pedido cambiarEstado(Long pedidoId, Estado nuevoEstado);
    List<PedidoFullDto> findByClienteId(Long clienteId);

}
