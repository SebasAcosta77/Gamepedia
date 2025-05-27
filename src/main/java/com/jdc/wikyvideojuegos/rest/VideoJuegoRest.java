package com.jdc.wikyvideojuegos.rest;

import com.jdc.wikyvideojuegos.DTO.VideoJuegoDTO;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;
import com.jdc.wikyvideojuegos.service.IVideoJuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wiky/videojuego")
public class VideoJuegoRest {

    @Autowired
    private IVideoJuegoService videoJuegoService;

    @PostMapping("/crear")
    public ResponseEntity<VideoJuegoEntity> create(
            @Validated @RequestBody VideoJuegoDTO videojuegoDTO
    ){
        try{
            VideoJuegoEntity miVideo = videoJuegoService.save(videojuegoDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miVideo);
        } catch (Exception e) {
            System.out.println("Error al crear el videojuego: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/list")
    private ResponseEntity<List<VideoJuegoEntity>> list(){
        return ResponseEntity.ok(videoJuegoService.findAll());
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<VideoJuegoEntity> edit(
            @Validated @RequestBody VideoJuegoDTO videoRequest, @PathVariable("id") Long id
    ) {
        VideoJuegoEntity updatedVideo = videoJuegoService.update(id, videoRequest);
        if (updatedVideo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVideo);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<String> deleteByi(@PathVariable("id") Long id) {
        videoJuegoService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado el vieojuego");
    }
}
