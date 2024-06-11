package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.DetallePedidoFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.detallePedido.DetallePedidoFullDto;
import com.entidades.buenSabor.domain.entities.DetallePedido;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoFacadeImp extends BaseFacadeImp<DetallePedido, DetallePedidoFullDto, Long> implements DetallePedidoFacade {

    public DetallePedidoFacadeImp(BaseService<DetallePedido, Long> baseService, BaseMapper<DetallePedido, DetallePedidoFullDto> baseMapper) {
        super(baseService, baseMapper);
    }

}
