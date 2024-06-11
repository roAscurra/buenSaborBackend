package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.ArticuloManufacturadoDetalleFacadeImp;
import com.entidades.buenSabor.domain.dto.articuloInsumo.ArticuloInsumoFullDto;
import com.entidades.buenSabor.domain.dto.articuloManufacturadoDetalle.ArticuloManufacturadoDetalleFullDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articuloManufacturadoDetalle")
@CrossOrigin("*")
public class ArticuloManufacturadoDetalleController extends BaseControllerImp<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleFullDto, Long, ArticuloManufacturadoDetalleFacadeImp> {

    public ArticuloManufacturadoDetalleController(ArticuloManufacturadoDetalleFacadeImp facade) { super(facade); }

    @GetMapping("/{id}")
    public ResponseEntity<ArticuloManufacturadoDetalleFullDto> getById(@PathVariable Long id){
        return super.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<ArticuloManufacturadoDetalleFullDto>> getAll() {
        return super.getAll();
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ArticuloManufacturadoDetalleFullDto> create(@RequestBody ArticuloManufacturadoDetalleFullDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ArticuloManufacturadoDetalleFullDto> edit(@RequestBody ArticuloManufacturadoDetalleFullDto entity, @PathVariable Long id){
        return super.edit(entity, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }
}
