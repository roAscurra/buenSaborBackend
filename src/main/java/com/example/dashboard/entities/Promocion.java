package com.example.dashboard.entities;

import com.example.dashboard.entities.enums.TipoPromocion;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Promocion extends Base{
    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "FechaDesde")
    private LocalDate fechaDesde;
    @Column(name = "FechaHasta")
    private LocalDate fechaHasta;
    @Column(name = "HoraDesde")
    private LocalTime horaDesde;
    @Column(name = "HoraHasta")
    private LocalTime horaHasta;
    @Column(name = "descripcionDescuento")
    private String descripcionDescuento;
    @Column(name = "precioPromocional")
    private Double precioPromocional;
    @Column(name = "tipoPromocion")
    private TipoPromocion tipoPromocion;


//    @OneToMany(mappedBy = "promocion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Imagen> imagenes;


    @ManyToMany
    @JoinTable(name = "promocion_articulos",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "promocion_id"))
    @Builder.Default
    private List<Articulo> articulos = new ArrayList<>();
}
