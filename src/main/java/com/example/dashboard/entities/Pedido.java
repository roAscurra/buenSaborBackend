package com.example.dashboard.entities;

import com.example.dashboard.entities.enums.Estado;
import com.example.dashboard.entities.enums.FormaPago;
import com.example.dashboard.entities.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Pedido extends Base{
    @Column(name = "horaEstimadaFinalizacion")
    private LocalTime horaEstimadaFinalizacion;
    @Column(name = "total")
    private Double total;
    @Column(name = "totalCosto")
    private Double totalCosto;
    @Column(name = "estado")
    private Estado estado;
    @Column(name = "formaPago")
    private FormaPago formaPago;
    @Column(name = "FechaPedido")
    private LocalDate FechaPedido;
    @Column(name = "TipoEnvio")
    private TipoEnvio tipoEnvio;

    @ManyToOne
    @JoinColumn(name="domicilio_id")
    private Domicilio domicilio;

    @ManyToOne
    @JoinColumn(name="sucursal_id")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @OneToOne(mappedBy = "pedido")
    private Factura factura;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetallePedido> detallePedidos ;
//nullable false
}
