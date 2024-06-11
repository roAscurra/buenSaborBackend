package com.entidades.buenSabor.domain.dto.articuloManufacturadoDetalle;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.articuloInsumo.ArticuloInsumoShortDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoDetalleShorDto extends BaseDto {
    private Integer cantidad;
    private ArticuloInsumoShortDto articuloInsumo;
}
