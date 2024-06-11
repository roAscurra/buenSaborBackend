package com.entidades.buenSabor.domain.dto.detallePedido;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetallePedidoCreateDto extends BaseDto {
    private Integer cantidad;
    private Double subTotal;
}
