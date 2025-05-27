package com.jdc.wikyvideojuegos.rest;

import com.jdc.wikyvideojuegos.DTO.UsuarioDTO;
import com.jdc.wikyvideojuegos.Entities.UsuarioEntity;
import com.jdc.wikyvideojuegos.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wiky/usuario")
public class UsuarioRest {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<UsuarioEntity> create(
            @Validated @RequestBody UsuarioDTO usuarioDTO
    ){
        try{
            UsuarioEntity miUsuario = usuarioService.save(usuarioDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miUsuario);
        } catch (Exception e) {
            System.out.println("Error al crear el usuario: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/list")
    private ResponseEntity<List<UsuarioEntity>> list(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<UsuarioEntity> edit(
            @Validated @RequestBody UsuarioDTO usuarioRequest, @PathVariable("id") Long id
    ) {
        UsuarioEntity updatedUsuario = usuarioService.update(id, usuarioRequest);
        if (updatedUsuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<String> deleteByi(@PathVariable("id") Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado el usuario");
    }
}
