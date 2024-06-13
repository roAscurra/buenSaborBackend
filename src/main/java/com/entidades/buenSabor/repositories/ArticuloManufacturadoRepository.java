package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long> {
    @Query("SELECT p FROM ArticuloManufacturado p WHERE p.sucursal.id = :idSucursal")
    List<ArticuloManufacturado> manufacturados(@Param("idSucursal") Long idSucursal);
}
