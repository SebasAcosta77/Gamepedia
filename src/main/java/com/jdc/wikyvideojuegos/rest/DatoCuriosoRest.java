package com.jdc.wikyvideojuegos.rest;

import com.jdc.wikyvideojuegos.DTO.DatoCuriosoDTO;
import com.jdc.wikyvideojuegos.Entities.DatoCuriosoEntity;
import com.jdc.wikyvideojuegos.service.IDatoCuriosoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wiky/datocurioso")
public class DatoCuriosoRest {

    @Autowired
    private IDatoCuriosoService datocuriosoService;

    @PostMapping("/crear")
    public ResponseEntity<DatoCuriosoEntity> create(
            @Validated @RequestBody DatoCuriosoDTO datoDTO
    ){
        try{
            DatoCuriosoEntity midato = datocuriosoService.save(datoDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(midato);
        } catch (Exception e) {
            System.out.println("Error al crear el datocurioso: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/list")
    private ResponseEntity<List<DatoCuriosoEntity>> list(){
        return ResponseEntity.ok(datocuriosoService.findAll());
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<DatoCuriosoEntity> edit(
            @Validated @RequestBody DatoCuriosoDTO citaRequest, @PathVariable("id") Long id
    ) {
        DatoCuriosoEntity updatedDato = datocuriosoService.update(id, citaRequest);
        if (updatedDato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDato);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<String> deleteByi(@PathVariable("id") Long id) {
        datocuriosoService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado datocurioso");
    }
}
