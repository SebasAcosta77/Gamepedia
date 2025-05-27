package com.jdc.wikyvideojuegos.rest;

import com.jdc.wikyvideojuegos.DTO.HistoriaRealDTO;
import com.jdc.wikyvideojuegos.Entities.HistoriaRealEntity;
import com.jdc.wikyvideojuegos.service.IHistoriaRealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wiky/historiareal")
public class HistoriaRealRest {

    @Autowired
    private IHistoriaRealService historiaRealService;

    @PostMapping("/crear")
    public ResponseEntity<HistoriaRealEntity> create(
            @Validated @RequestBody HistoriaRealDTO historiaDTO
    ){
        try{
            HistoriaRealEntity miHistoria = historiaRealService.save(historiaDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miHistoria);
        } catch (Exception e) {
            System.out.println("Error al crear la historia real: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/list")
    private ResponseEntity<List<HistoriaRealEntity>> list(){
        return ResponseEntity.ok(historiaRealService.findAll());
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<HistoriaRealEntity> edit(
            @Validated @RequestBody HistoriaRealDTO historiaRequest, @PathVariable("id") Long id
    ) {
        HistoriaRealEntity updatedHistoria = historiaRealService.update(id, historiaRequest);
        if (updatedHistoria == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedHistoria);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<String> deleteByi(@PathVariable("id") Long id) {
        historiaRealService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado la historia real");
    }
}
