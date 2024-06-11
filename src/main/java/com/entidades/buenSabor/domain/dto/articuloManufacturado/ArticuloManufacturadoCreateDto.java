package com.entidades.buenSabor.domain.dto.articuloManufacturado;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.articuloManufacturadoDetalle.ArticuloManufacturadoDetalleCreateDto;
import com.entidades.buenSabor.domain.dto.imagen.ImagenDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoCreateDto extends BaseDto {
    //de articulo
    private String denominacion;
    private Double precioVenta;
    //de imagenArticulo
//    private Set<ImagenDto> imagenes;
    //propios de la entidad
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;
    //de unidad medida
    private Long idUnidadMedida;
    //de articuloManufacturadoDetalle
    private Set<ArticuloManufacturadoDetalleCreateDto> ArticuloManufacturadoDetalles;
}
