package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long> {
    @Query("SELECT DISTINCT p FROM ArticuloManufacturado p JOIN FETCH p.imagenes i " +
            "WHERE p.sucursal.id = :idSucursal AND i.eliminado = false AND p.eliminado = false")
    List<ArticuloManufacturado> manufacturados(@Param("idSucursal") Long idSucursal);

}
