package com.entidades.buenSabor.domain.dto.imagen;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImagenArticuloFullDto extends BaseDto {
    private String denominacion;
}
