package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.Service.KilometreService;
import com.fullstack.quizcars.classes.Kilometre;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

public class KilometreController {
    @Autowired

    private com.fullstack.quizcars.Service.KilometreService KilometreService;
    @GetMapping("/Kilometre")
    public List<Kilometre> getKilometre()
    {
        return KilometreService.getKilometre();
    }

    @GetMapping("/Kilometre/{id}")
    public Kilometre getKilometre(@PathVariable long id){
        return KilometreService.getKilometreById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Kilometre")
    public Kilometre addKilometre(@RequestBody Kilometre Kilometre){
        return KilometreService.save(Kilometre);
    }
    @PutMapping("/Kilometre/{id}")
    public ResponseEntity<?> addKilometre(@RequestBody Kilometre Kilometre , @PathVariable Long id){
        if( KilometreService.existById(id)){
            Kilometre Kilometre1 =KilometreService.getKilometreById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
           Kilometre1.setType(Kilometre.getType());
          //  Kilometre1.setEtat(Kilometre.getEtat());

            KilometreService.save(Kilometre);
            return ResponseEntity.ok().body(Kilometre1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Kilometre/{id}")
    public ResponseEntity<?> deleteKilometre(@RequestBody Kilometre Kilometre ,@PathVariable Long id){
        if( KilometreService.existById(id)){
            KilometreService.deleteKilometre(id);
            HashMap<String,String> message=new HashMap<>();
            message.put("message",id+"deleted");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
