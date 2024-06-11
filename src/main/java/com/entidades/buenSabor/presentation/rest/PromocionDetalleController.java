package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.PromocionDetalleFacadeImp;
import com.entidades.buenSabor.domain.dto.promocion.PromocionFullDto;
import com.entidades.buenSabor.domain.dto.promocionDetalle.PromocionDetalleFullDto;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promocionDetalle")
@CrossOrigin("*")
public class PromocionDetalleController extends BaseControllerImp<PromocionDetalle, PromocionDetalleFullDto, Long, PromocionDetalleFacadeImp> {

    public PromocionDetalleController(PromocionDetalleFacadeImp facade) {super(facade);}

    @GetMapping("/{id}")
    public ResponseEntity<PromocionDetalleFullDto> getById(@PathVariable Long id){
        return super.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<PromocionDetalleFullDto>> getAll() {
        return super.getAll();
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PromocionDetalleFullDto> create(@RequestBody PromocionDetalleFullDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PromocionDetalleFullDto> edit(@RequestBody PromocionDetalleFullDto entity, @PathVariable Long id){
        return super.edit(entity, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }

}
