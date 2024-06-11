package com.example.dashboard.repositories;

import com.example.dashboard.entities.Articulo;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends BaseRepository<Articulo, Long> {
}
