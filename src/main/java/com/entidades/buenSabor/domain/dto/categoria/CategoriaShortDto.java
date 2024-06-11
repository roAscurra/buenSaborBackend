package com.entidades.buenSabor.domain.dto.categoria;


import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.sucursal.SucursalCreateDto;
import com.entidades.buenSabor.domain.dto.sucursal.SucursalShortDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaShortDto extends BaseDto {
    private String denominacion;
    private boolean esInsumo;
}
