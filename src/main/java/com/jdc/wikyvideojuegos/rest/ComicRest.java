package com.jdc.wikyvideojuegos.rest;

import com.jdc.wikyvideojuegos.DTO.ComicDTO;
import com.jdc.wikyvideojuegos.Entities.ComicEntity;
import com.jdc.wikyvideojuegos.service.IComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wiky/comic")
public class ComicRest {
    @Autowired
    private IComicService comicService;

    @PostMapping("/crear")
    public ResponseEntity<ComicEntity> create(
            @Validated @RequestBody ComicDTO comicDTO
    ){
        try{
            ComicEntity miComic = comicService.save(comicDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miComic);
        } catch (Exception e) {
            System.out.println("Error al crear el comic: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/list")
    private ResponseEntity<List<ComicEntity>> list(){
        return ResponseEntity.ok(comicService.findAll());
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<ComicEntity> edit(
            @Validated @RequestBody ComicDTO comicRequest, @PathVariable("id") Long id
    ) {
        ComicEntity updatedComic = comicService.update(id, comicRequest);
        if (updatedComic == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedComic);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<String> deleteByi(@PathVariable("id") Long id) {
        comicService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado el comic");
    }
}
