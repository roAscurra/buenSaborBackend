package com.example.dashboard.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Cliente extends Base{
    @Column(name = "nombre")
    private String nombre;
    @Column(name ="apellido")
    private String apellido;
    @Column(name ="telefono")
    private String telefono;
    @Column(name ="email")
    private String email;
    @Column(name ="fechaNacimiento")
    private LocalDate fechaNacimiento;

    @OneToOne
    private Usuario usuario;

    @OneToOne
    private Imagen imagen;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default //Builder no sobreescribe la inicializacion de la lista
    private List<Pedido> pedidos = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    //JoinTable crea una tabla intermedia
    @JoinTable  (name = "cliente_domicilio",
                joinColumns = @JoinColumn(name = "cliente_id"),
                inverseJoinColumns = @JoinColumn(name = "domicilio_id"))
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();
}
