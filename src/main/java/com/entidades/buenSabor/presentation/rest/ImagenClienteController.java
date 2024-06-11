package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.ImagenClienteFacadeImp;
import com.entidades.buenSabor.domain.dto.imagen.ImagenClienteFullDto;
import com.entidades.buenSabor.domain.entities.ImagenCliente;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.hibernate.mapping.Bag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imagenCliente")
@CrossOrigin("*")
public class ImagenClienteController extends BaseControllerImp<ImagenCliente, ImagenClienteFullDto, Long, ImagenClienteFacadeImp> {

    public ImagenClienteController(ImagenClienteFacadeImp facade) {super (facade); }

}
