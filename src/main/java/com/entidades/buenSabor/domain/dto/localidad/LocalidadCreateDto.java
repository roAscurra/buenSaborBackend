package com.entidades.buenSabor.domain.dto.localidad;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocalidadCreateDto extends BaseDto {
    private String nombre;
    private Long idProvincia;
}
