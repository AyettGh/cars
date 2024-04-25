package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.Service.MarqueService;
import com.fullstack.quizcars.Service.ModeleService;
import com.fullstack.quizcars.classes.Marque;
import com.fullstack.quizcars.classes.Modele;
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
public class ModeleController {
    @Autowired

    private com.fullstack.quizcars.Service.ModeleService ModeleService;
    MarqueService MarqueService;

    @GetMapping("/Modele/marque/{marqueId}")
    public List<Modele> getModeleByMarque(@PathVariable Long marqueId) {
        return ModeleService.getModeleByMarque(marqueId);
    }

    @GetMapping("/Modele/{id}")
    public Modele getModele(@PathVariable long id){
        return ModeleService.getModeleById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Modele/{marqueId}")
    public Modele addModele(@RequestBody Modele modele, @PathVariable Long marqueId) {
        Marque marque = MarqueService.getMarqueById(marqueId).orElseThrow(
                () -> new EntityNotFoundException("Marque not found")
        );
        modele.setMarque(marque);
        return ModeleService.save(modele);
    }
    @PutMapping("/Modele/{id}")
    public ResponseEntity<?> updateModele(@RequestBody Modele Modele , @PathVariable Long id){
        if( ModeleService.existById(id)){
            Modele Modele1 =ModeleService.getModeleById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
            Modele1.setName(Modele.getName());
            //Modele1.setModeles(Modele.getModeles());
            //Modele1.setMarque(Modele.getMarque());

            ModeleService.save(Modele);
            return ResponseEntity.ok().body(Modele1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Modele/{id}")
    public ResponseEntity<?> deleteModele(@RequestBody Modele Modele ,@PathVariable Long id){
        if( ModeleService.existById(id)){
            ModeleService.deleteModele(id);
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
