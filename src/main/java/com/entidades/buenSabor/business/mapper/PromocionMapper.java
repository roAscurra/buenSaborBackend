package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.promocion.PromocionFullDto;
import com.entidades.buenSabor.domain.entities.Promocion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SucursalMapper.class})
public interface PromocionMapper extends BaseMapper<Promocion, PromocionFullDto>{
}
