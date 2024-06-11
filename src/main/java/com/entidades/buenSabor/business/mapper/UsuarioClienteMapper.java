package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.usuarioCliente.UsuarioClienteFullDto;
import com.entidades.buenSabor.domain.entities.UsuarioCliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioClienteMapper extends BaseMapper<UsuarioCliente, UsuarioClienteFullDto>{
}
