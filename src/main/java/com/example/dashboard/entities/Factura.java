package com.example.dashboard.entities;

import com.example.dashboard.entities.enums.FormaPago;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Factura extends Base{
    @Column(name = "fechaFacturacion")
    private LocalDate fechaFacturacion;
    @Column(name = "mpPaymentId")
    private Integer mpPaymentId;
    @Column(name = "mpMerchantOrderId")
    private Integer mpMerchantOrderId;
    @Column(name = "mpPreferenceId")
    private String mpPreferenceId;
    @Column(name = "mpPaymentType")
    private String mpPaymentType;
    @Column(name = "formaPago")
    private FormaPago formaPago;
    @Column(name = "totalVenta")
    private Double totalVenta;

    
    @OneToOne
    private Pedido pedido;

}
