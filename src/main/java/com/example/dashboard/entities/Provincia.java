package com.example.dashboard.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Provincia extends Base{
    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn (name="pais_id")
    private Pais pais;
}
