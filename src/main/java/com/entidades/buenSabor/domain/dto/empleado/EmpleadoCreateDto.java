package com.entidades.buenSabor.domain.dto.empleado;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.enums.Rol;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoCreateDto extends BaseDto {
    private Rol tipoEmpleado;
}
