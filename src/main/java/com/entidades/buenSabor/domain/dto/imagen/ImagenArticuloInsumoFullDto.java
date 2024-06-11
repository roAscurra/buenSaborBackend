package com.entidades.buenSabor.domain.dto.imagen;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.articuloInsumo.ArticuloInsumoFullDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImagenArticuloInsumoFullDto extends BaseDto {
    private ArticuloInsumoFullDto articulo;
    private ImagenArticuloFullDto denominacion;
}
