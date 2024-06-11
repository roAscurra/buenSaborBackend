package com.example.dashboard.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Domicilio extends Base{
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "cp")
    private Integer cp;
    @Column(name = "piso")
    private Integer piso;
    @Column(name = "nroDpto")
    private Integer nroDpto;

    @ManyToOne
    @JoinColumn(name="localidad_id")
    private Localidad localidad;


    @OneToMany(mappedBy = "domicilio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default //Builder no sobreescribe la inicializacion de la lista
    private List<Pedido> pedidos = new ArrayList<>();
}
