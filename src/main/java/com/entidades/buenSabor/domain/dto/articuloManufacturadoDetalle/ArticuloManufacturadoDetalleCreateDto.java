package com.entidades.buenSabor.domain.dto.articuloManufacturadoDetalle;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoDetalleCreateDto extends BaseDto {
    private Integer cantidad;
    //de articuloInsumo
    private Long articuloInsumo;
}
