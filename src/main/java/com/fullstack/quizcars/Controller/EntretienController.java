package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.classes.Entretien;
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
public class EntretienController {
    @Autowired

    private com.fullstack.quizcars.Service.EntretienService EntretienService;
    @GetMapping("/Entretien")
    public List<Entretien> getEntretien()
    {
        return EntretienService.getEntretien();
    }

    @GetMapping("/Entretien/{id}")
    public Entretien getEntretien(@PathVariable long id){
        return EntretienService.getEntretienById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Entretien")
    public Entretien addEntretien(@RequestBody Entretien Entretien){
        return EntretienService.save(Entretien);
    }
    @PutMapping("/Entretien/{id}")
    public ResponseEntity<?> addEntretien(@RequestBody Entretien Entretien , @PathVariable Long id){
        if( EntretienService.existById(id)){
            Entretien Entretien1 =EntretienService.getEntretienById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
               Entretien1.setType(Entretien.getType());
            Entretien1.setEtat(Entretien.getEtat());

            EntretienService.save(Entretien);
            return ResponseEntity.ok().body(Entretien1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Entretien/{id}")
    public ResponseEntity<?> deleteEntretien(@RequestBody Entretien Entretien ,@PathVariable Long id){
        if( EntretienService.existById(id)){
            EntretienService.deleteEntretien(id);
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
