package com.jdc.wikyvideojuegos.rest;

import com.jdc.wikyvideojuegos.DTO.ComentarioDTO;
import com.jdc.wikyvideojuegos.Entities.ComentarioEntity;
import com.jdc.wikyvideojuegos.service.IComnetarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wiky/comentario")
public class ComentarioRest {
    @Autowired
    private IComnetarioService comentarioService;

    @PostMapping("/crear")
    public ResponseEntity<ComentarioEntity> create(
            @Validated @RequestBody ComentarioDTO comentarioDTO
    ){
        try{
            ComentarioEntity miComentario = comentarioService.save(comentarioDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miComentario);
        } catch (Exception e) {
            System.out.println("Error al crear el comentario: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/list")
    private ResponseEntity<List<ComentarioEntity>> list(){
        return ResponseEntity.ok(comentarioService.findAll());
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<ComentarioEntity> edit(
            @Validated @RequestBody ComentarioDTO citaRequest, @PathVariable("id") Long id
    ) {
        ComentarioEntity updatedComentario = comentarioService.update(id, citaRequest);
        if (updatedComentario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedComentario);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<String> deleteByi(@PathVariable("id") Long id) {
        comentarioService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado la cita");
    }
}
