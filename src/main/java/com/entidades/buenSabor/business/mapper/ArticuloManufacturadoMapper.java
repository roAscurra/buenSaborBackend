package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.articuloManufacturado.ArticuloManufacturadoFullDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ArticuloManufacturadoMapper extends BaseMapper<ArticuloManufacturado, ArticuloManufacturadoFullDto> {
}
