package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.UsuarioClienteFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.usuarioCliente.UsuarioClienteFullDto;
import com.entidades.buenSabor.domain.entities.UsuarioCliente;
import org.springframework.stereotype.Service;

@Service
public class UsuarioClienteFacadeImp extends BaseFacadeImp<UsuarioCliente, UsuarioClienteFullDto, Long> implements UsuarioClienteFacade {

    public UsuarioClienteFacadeImp(BaseService<UsuarioCliente, Long> baseService, BaseMapper<UsuarioCliente, UsuarioClienteFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
