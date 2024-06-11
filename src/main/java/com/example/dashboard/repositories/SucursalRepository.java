package com.example.dashboard.repositories;

import com.example.dashboard.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends BaseRepository<Sucursal, Long> {
}
