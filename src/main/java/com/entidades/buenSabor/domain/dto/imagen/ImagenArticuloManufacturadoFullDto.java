package com.entidades.buenSabor.domain.dto.imagen;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.articuloInsumo.ArticuloInsumoFullDto;
import com.entidades.buenSabor.domain.dto.articuloManufacturado.ArticuloManufacturadoFullDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImagenArticuloManufacturadoFullDto extends BaseDto {
    private ArticuloManufacturadoFullDto articuloManufacturado;
    private ImagenArticuloFullDto denominacion;
}
