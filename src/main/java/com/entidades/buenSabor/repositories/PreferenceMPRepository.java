package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.PreferenceMP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceMPRepository extends JpaRepository<PreferenceMP, String> {
}
