package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.imagen.ImagenClienteFullDto;
import com.entidades.buenSabor.domain.entities.ImagenCliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImagenClienteMapper extends BaseMapper<ImagenCliente, ImagenClienteFullDto>{
}
