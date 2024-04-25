package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.classes.ConsommationHuile;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/q")
public class ConsommationHuileController {
    @Autowired

    private com.fullstack.quizcars.Service.ConsommationHuileService ConsommationHuileService;
    @GetMapping("/ConsommationHuile")
    public List<ConsommationHuile> getConsommationHuile()
    {
        return ConsommationHuileService.getConsommationHuile();
    }

    @GetMapping("/ConsommationHuile/{id}")
    public ConsommationHuile getConsommationHuile(@PathVariable long id){
        return ConsommationHuileService.getConsommationHuileById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/ConsommationHuile")
    public ConsommationHuile addConsommationHuile(@RequestBody ConsommationHuile ConsommationHuile){
        return ConsommationHuileService.save(ConsommationHuile);
    }
    @PutMapping("/ConsommationHuile/{id}")
    public ResponseEntity<?> addConsommationHuile(@RequestBody ConsommationHuile ConsommationHuile , @PathVariable Long id){
        if( ConsommationHuileService.existById(id)){
            ConsommationHuile ConsommationHuile1 =ConsommationHuileService.getConsommationHuileById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
               ConsommationHuile1.setType(ConsommationHuile.getType());
           // ConsommationHuile1.setEtat(ConsommationHuile.getEtat());

            ConsommationHuileService.save(ConsommationHuile);
            return ResponseEntity.ok().body(ConsommationHuile1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/ConsommationHuile/{id}")
    public ResponseEntity<?> deleteConsommationHuile(@RequestBody ConsommationHuile ConsommationHuile ,@PathVariable Long id){
        if( ConsommationHuileService.existById(id)){
            ConsommationHuileService.deleteConsommationHuile(id);
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
