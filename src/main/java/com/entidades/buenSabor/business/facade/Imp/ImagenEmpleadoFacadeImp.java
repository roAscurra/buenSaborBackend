package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.ImagenEmpleadoFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.imagen.ImagenEmpleadoFullDto;
import com.entidades.buenSabor.domain.entities.ImagenEmpleado;
import org.springframework.stereotype.Service;

@Service
public class ImagenEmpleadoFacadeImp extends BaseFacadeImp<ImagenEmpleado, ImagenEmpleadoFullDto, Long> implements ImagenEmpleadoFacade {
    public ImagenEmpleadoFacadeImp(BaseService<ImagenEmpleado, Long> baseService, BaseMapper<ImagenEmpleado, ImagenEmpleadoFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
