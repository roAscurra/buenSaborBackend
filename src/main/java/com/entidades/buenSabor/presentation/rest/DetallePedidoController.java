package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.DetallePedidoFacadeImp;
import com.entidades.buenSabor.domain.dto.detallePedido.DetallePedidoFullDto;
import com.entidades.buenSabor.domain.entities.DetallePedido;
import com.entidades.buenSabor.presentation.rest.Base.BaseController;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detallePedido")
@CrossOrigin("*")
public class DetallePedidoController extends BaseControllerImp<DetallePedido, DetallePedidoFullDto, Long, DetallePedidoFacadeImp> {

    public DetallePedidoController(DetallePedidoFacadeImp facade) {super (facade); }
}
