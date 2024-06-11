package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.ImagenPromocionFacadeImp;
import com.entidades.buenSabor.domain.dto.imagen.ImagenPromocionFullDto;
import com.entidades.buenSabor.domain.entities.ImagenPromocion;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imagenPromocion")
@CrossOrigin("*")
public class ImagenPromocionController extends BaseControllerImp<ImagenPromocion, ImagenPromocionFullDto, Long, ImagenPromocionFacadeImp> {

    public ImagenPromocionController(ImagenPromocionFacadeImp facade) { super (facade); }

}
