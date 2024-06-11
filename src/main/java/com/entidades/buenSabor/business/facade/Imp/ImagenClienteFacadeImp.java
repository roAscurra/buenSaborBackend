package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.ImagenClienteFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.imagen.ImagenClienteFullDto;
import com.entidades.buenSabor.domain.entities.ImagenCliente;
import org.springframework.stereotype.Service;

@Service
public class ImagenClienteFacadeImp extends BaseFacadeImp<ImagenCliente, ImagenClienteFullDto, Long> implements ImagenClienteFacade {

    public ImagenClienteFacadeImp(BaseService<ImagenCliente, Long> baseService, BaseMapper<ImagenCliente, ImagenClienteFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
