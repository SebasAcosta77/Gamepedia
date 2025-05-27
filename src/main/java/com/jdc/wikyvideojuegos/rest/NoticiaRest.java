package com.jdc.wikyvideojuegos.rest;

import com.jdc.wikyvideojuegos.DTO.LoreDTO;
import com.jdc.wikyvideojuegos.DTO.NoticiaDTO;
import com.jdc.wikyvideojuegos.Entities.NoticiaEntity;
import com.jdc.wikyvideojuegos.service.INoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wiky/noticia")
public class NoticiaRest {

    @Autowired
    private INoticiaService noticiaService;

    @PostMapping("/crear")
    public ResponseEntity<NoticiaEntity> create(
            @Validated @RequestBody NoticiaDTO noticiaDTO
    ){
        try{
            NoticiaEntity miNoticia = noticiaService.save(noticiaDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miNoticia);
        } catch (Exception e) {
            System.out.println("Error al crear la noticia: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/list")
    private ResponseEntity<List<NoticiaDTO>> list(){
        List<NoticiaDTO> dtos = noticiaService.findAll().stream().map(lore -> {
            NoticiaDTO dto = new NoticiaDTO();

            dto.setIdnoticia(lore.getIdnoticia());
            dto.setTitulo(lore.getTitulo());
            dto.setContenido(lore.getContenido());
            dto.setFechapublicacion(lore.getFechapublicacion()); // usando el getter personalizado que ya tienes
            dto.setFuente(lore.getFuente()); // usando el getter personalizado que ya tienes
            dto.setVideojuego(lore.getIdVideojuego());
            return dto;
        }).toList();
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<NoticiaEntity> edit(
            @Validated @RequestBody NoticiaDTO noticiaRequest, @PathVariable("id") Long id
    ) {
        NoticiaEntity updatedNoticia = noticiaService.update(id, noticiaRequest);
        if (updatedNoticia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedNoticia);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<String> deleteByi(@PathVariable("id") Long id) {
        noticiaService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado la cita");
    }

}
