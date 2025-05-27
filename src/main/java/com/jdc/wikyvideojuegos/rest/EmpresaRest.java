package com.jdc.wikyvideojuegos.rest;


import com.jdc.wikyvideojuegos.DTO.EmpresaDTO;
import com.jdc.wikyvideojuegos.Entities.EmpresaEntity;
import com.jdc.wikyvideojuegos.service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wiky/empresa")
public class EmpresaRest {
    @Autowired
    private IEmpresaService empresaService;

    @PostMapping("/crear")
    public ResponseEntity<EmpresaEntity> create(
            @Validated @RequestBody EmpresaDTO empresaDTO
    ){
        try{
            EmpresaEntity miempresa = empresaService.save(empresaDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miempresa);
        } catch (Exception e) {
            System.out.println("Error al crear la empresa: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @GetMapping("/list")
    private ResponseEntity<List<EmpresaEntity>> list(){
        return ResponseEntity.ok(empresaService.findAll());
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<EmpresaEntity> edit(
            @Validated @RequestBody EmpresaDTO empresaRequest, @PathVariable("id") Long id
    ) {
        EmpresaEntity updatedEmpresa = empresaService.update(id, empresaRequest);
        if (updatedEmpresa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEmpresa);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<String> deleteByi(@PathVariable("id") Long id) {
        empresaService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado la empresa");
    }
}
