package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.imagen.ImagenEmpleadoFullDto;
import com.entidades.buenSabor.domain.entities.ImagenEmpleado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImagenEmpleadoMapper extends BaseMapper<ImagenEmpleado, ImagenEmpleadoFullDto>{
}
