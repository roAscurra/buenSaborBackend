package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.ImagenEmpleadoFacadeImp;
import com.entidades.buenSabor.domain.dto.imagen.ImagenEmpleadoFullDto;
import com.entidades.buenSabor.domain.entities.ImagenEmpleado;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imagenEmpleado")
@CrossOrigin("*")
public class ImagenEmpleadoController extends BaseControllerImp<ImagenEmpleado, ImagenEmpleadoFullDto, Long, ImagenEmpleadoFacadeImp> {

    public ImagenEmpleadoController(ImagenEmpleadoFacadeImp facade) {super (facade); }

}
