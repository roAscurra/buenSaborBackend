package com.entidades.buenSabor.domain.dto.imagen;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.promocion.PromocionFullDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImagenPromocionFullDto extends BaseDto {
    private String url;
    private PromocionFullDto promocion;
    private ImagenArticuloFullDto denominacion;
}
