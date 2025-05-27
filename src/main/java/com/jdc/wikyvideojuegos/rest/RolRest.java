package com.jdc.wikyvideojuegos.rest;

import com.jdc.wikyvideojuegos.DTO.RolDTO;
import com.jdc.wikyvideojuegos.Entities.RolEntity;
import com.jdc.wikyvideojuegos.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wiky/rol")
public class RolRest {
    @Autowired
    private IRolService rolService;

    @PostMapping("/crear")
    public ResponseEntity<RolEntity> create(
            @Validated @RequestBody RolDTO rolDTO
    ){
        try{
            RolEntity miRol = rolService.save(rolDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miRol);
        } catch (Exception e) {
            System.out.println("Error al crear el rol: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/list")
    private ResponseEntity<List<RolEntity>> list(){
        return ResponseEntity.ok(rolService.findAll());
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<RolEntity> edit(
            @Validated @RequestBody RolDTO rolRequest, @PathVariable("id") Long id
    ) {
        RolEntity updatedRol = rolService.update(id, rolRequest);
        if (updatedRol == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRol);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<String> deleteByi(@PathVariable("id") Long id) {
        rolService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado el rol");
    }

}
