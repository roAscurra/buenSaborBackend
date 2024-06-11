package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.EmpleadoFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.empleado.EmpleadoFullDto;
import com.entidades.buenSabor.domain.entities.Empleado;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoFacadeImp extends BaseFacadeImp<Empleado, EmpleadoFullDto, Long> implements EmpleadoFacade {
    public EmpleadoFacadeImp(BaseService<Empleado, Long> baseService, BaseMapper<Empleado, EmpleadoFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
