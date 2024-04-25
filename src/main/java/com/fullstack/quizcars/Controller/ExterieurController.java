package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.classes.Exterieur;
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
public class ExterieurController {
    @Autowired

    private com.fullstack.quizcars.Service.ExterieurService ExterieurService;
    @GetMapping("/Exterieur")
    public List<Exterieur> getExterieur()
    {
        return ExterieurService.getExterieur();
    }

    @GetMapping("/Exterieur/{id}")
    public Exterieur getExterieur(@PathVariable long id){
        return ExterieurService.getExterieurById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Exterieur")
    public Exterieur addExterieur(@RequestBody Exterieur Exterieur){
        return ExterieurService.save(Exterieur);
    }
    @PutMapping("/Exterieur/{id}")
    public ResponseEntity<?> addExterieur(@RequestBody Exterieur Exterieur , @PathVariable Long id){
        if( ExterieurService.existById(id)){
            Exterieur Exterieur1 =ExterieurService.getExterieurById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
            //   Exterieur1.setType(Exterieur.getType());
            //Exterieur1.setExterieurs(Exterieur.getExterieurs());

            ExterieurService.save(Exterieur);
            return ResponseEntity.ok().body(Exterieur1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Exterieur/{id}")
    public ResponseEntity<?> deleteExterieur(@RequestBody Exterieur Exterieur ,@PathVariable Long id){
        if( ExterieurService.existById(id)){
            ExterieurService.deleteExterieur(id);
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
