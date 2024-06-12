package com.entidades.buenSabor.repositories;


import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long> {
@Query("SELECT p FROM ArticuloInsumo p JOIN p.categoria c JOIN c.sucursales s WHERE s.id = :idSucursal AND p.esParaElaborar = true")
List<ArticuloInsumo> insumosPorSucursal(@Param("idSucursal") Long idSucursal);
}
