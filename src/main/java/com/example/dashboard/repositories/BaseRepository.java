package com.example.dashboard.repositories;

import com.example.dashboard.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends Base,ID extends Serializable> extends JpaRepository<T,ID> {

}
