package com.jdc.wikyvideojuegos.rest;

import com.jdc.wikyvideojuegos.DTO.ValoracionDTO;
import com.jdc.wikyvideojuegos.Entities.ValoracionEntity;
import com.jdc.wikyvideojuegos.service.IValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wiky/valoracion")
public class ValoracionRest {

    @Autowired
    private IValoracionService valoracionService;

    @PostMapping("/crear")
    public ResponseEntity<ValoracionEntity> create(
            @Validated @RequestBody ValoracionDTO valoracionDTO
    ){
        try{
            ValoracionEntity miValoracion = valoracionService.save(valoracionDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miValoracion);
        } catch (Exception e) {
            System.out.println("Error al crear la valoracion: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/list")
    private ResponseEntity<List<ValoracionEntity>> list(){
        return ResponseEntity.ok(valoracionService.findAll());
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<ValoracionEntity> edit(
            @Validated @RequestBody ValoracionDTO valoracionRequest, @PathVariable("id") Long id
    ) {
        ValoracionEntity updatedValoracion = valoracionService.update(id, valoracionRequest);
        if (updatedValoracion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedValoracion);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<String> deleteByi(@PathVariable("id") Long id) {
        valoracionService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado la cita");
    }
}
