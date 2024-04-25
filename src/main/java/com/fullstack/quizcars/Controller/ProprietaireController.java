package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.Service.ProprietaireService;
import com.fullstack.quizcars.classes.Proprietaire;
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
public class ProprietaireController {
    @Autowired

    private com.fullstack.quizcars.Service.ProprietaireService ProprietaireService;
    @GetMapping("/Proprietaire")
    public List<Proprietaire> getProprietaire()
    {
        return ProprietaireService.getProprietaire();
    }

    @GetMapping("/Proprietaire/{id}")
    public Proprietaire getProprietaire(@PathVariable long id){
        return ProprietaireService.getProprietaireById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Proprietaire")
    public Proprietaire addProprietaire(@RequestBody Proprietaire Proprietaire){
        return ProprietaireService.save(Proprietaire);
    }
    @PutMapping("/Proprietaire/{id}")
    public ResponseEntity<?> addProprietaire(@RequestBody Proprietaire Proprietaire , @PathVariable Long id){
        if( ProprietaireService.existById(id)){
            Proprietaire Proprietaire1 =ProprietaireService.getProprietaireById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
            Proprietaire1.setType(Proprietaire.getType());
           // Proprietaire1.setEtat(Proprietaire.getEtat());

            ProprietaireService.save(Proprietaire);
            return ResponseEntity.ok().body(Proprietaire1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Proprietaire/{id}")
    public ResponseEntity<?> deleteProprietaire(@RequestBody Proprietaire Proprietaire ,@PathVariable Long id){
        if( ProprietaireService.existById(id)){
            ProprietaireService.deleteProprietaire(id);
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
