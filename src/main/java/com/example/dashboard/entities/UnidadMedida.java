package com.example.dashboard.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UnidadMedida extends Base {
    @Column
    private String denominacion;

    @OneToMany(mappedBy = "unidadMedida", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Articulo> articulos;
}
