package com.entidades.buenSabor.domain.entities;

import com.entidades.buenSabor.domain.enums.Rol;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Audited
public class Usuario extends Base{
    private String auth0Id;
    private String username;
    private String email;
    private Rol rol;

//    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REFRESH, orphanRemoval = true)
//    @ToString.Exclude
//    @Builder.Default
//    private Set<Pedido> pedidos= new HashSet<>();
}
