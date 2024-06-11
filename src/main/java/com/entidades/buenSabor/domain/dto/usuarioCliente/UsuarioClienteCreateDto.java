package com.entidades.buenSabor.domain.dto.usuarioCliente;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioClienteCreateDto extends BaseDto {
    private String Auth0id;
    private String username;
}
