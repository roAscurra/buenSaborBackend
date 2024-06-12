package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.domain.entities.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromocionRepository extends BaseRepository<Promocion,Long>{

    @Query("SELECT c FROM Promocion c JOIN c.sucursales s WHERE s.id = :idSucursal")
    List<Promocion> promocionSucursal(@Param("idSucursal") Long idSucursal);
}
