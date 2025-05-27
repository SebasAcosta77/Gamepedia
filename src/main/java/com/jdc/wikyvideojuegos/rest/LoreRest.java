package com.jdc.wikyvideojuegos.rest;

import com.jdc.wikyvideojuegos.DTO.DatoCuriosoDTO;
import com.jdc.wikyvideojuegos.DTO.LoreDTO;
import com.jdc.wikyvideojuegos.Entities.ComicEntity;
import com.jdc.wikyvideojuegos.Entities.DatoCuriosoEntity;
import com.jdc.wikyvideojuegos.Entities.LoreEntity;
import com.jdc.wikyvideojuegos.service.ILoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wiky/lore")
public class LoreRest {
    @Autowired
    private ILoreService loreService;

    @PostMapping("/crear")
    public ResponseEntity<LoreEntity> create(
            @Validated @RequestBody LoreDTO loreDTO
    ){
        try{
            LoreEntity miLore = loreService.save(loreDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miLore);
        } catch (Exception e) {
            System.out.println("Error al crear el lore: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/list")
    private ResponseEntity<List<LoreDTO>> list(){
        List<LoreDTO> dtos = loreService.findAll().stream().map(lore -> {
            LoreDTO dto = new LoreDTO();
            dto.setIdlore(lore.getIdlore());
            dto.setDescripcion(lore.getDescripcion());
            dto.setLineatiempo(lore.getLineatiempo());
            dto.setVideojuego(lore.getIdVideojuego()); // usando el getter personalizado que ya tienes
            return dto;
        }).toList();
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<LoreDTO> edit(
            @Validated @RequestBody LoreDTO loreRequest, @PathVariable("id") Long id
    ) {
        LoreEntity updatedLore = loreService.update(id, loreRequest);

        if (updatedLore == null) {
            return ResponseEntity.notFound().build();
        }

        // Convertimos LoreEntity a LoreResponseDTO
        LoreDTO response = new LoreDTO();
        response.setDescripcion(updatedLore.getDescripcion());
        response.setLineatiempo(updatedLore.getLineatiempo());

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<String> deleteByi(@PathVariable("id") Long id) {
        loreService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado el lore");
    }

}
