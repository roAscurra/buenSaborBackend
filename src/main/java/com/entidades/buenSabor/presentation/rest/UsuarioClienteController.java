package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.UsuarioClienteFacadeImp;
import com.entidades.buenSabor.domain.dto.usuarioCliente.UsuarioClienteFullDto;
import com.entidades.buenSabor.domain.entities.Base;
import com.entidades.buenSabor.domain.entities.UsuarioCliente;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarioCliente")
@CrossOrigin("*")
public class UsuarioClienteController extends BaseControllerImp<UsuarioCliente, UsuarioClienteFullDto, Long, UsuarioClienteFacadeImp> {

    public UsuarioClienteController(UsuarioClienteFacadeImp facade) {super (facade); }

}
