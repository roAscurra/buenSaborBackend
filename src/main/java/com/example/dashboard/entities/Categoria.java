package com.example.dashboard.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Categoria extends Base{

    @Column(name = "denominacion")
    private String denominacion;

    @OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Articulo> articulos;

    @ManyToOne
    @JoinColumn (name = "categoriaPadre")
    private Categoria categoriaPadre;

    @OneToMany( mappedBy = "categoriaPadre",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Categoria> subCategoria;

}
