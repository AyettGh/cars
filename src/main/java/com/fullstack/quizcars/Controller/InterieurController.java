package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.classes.Interieur;
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
public class InterieurController
{
    @Autowired

    private com.fullstack.quizcars.Service.InterieurService InterieurService;
    @GetMapping("/Interieur")
    public List<Interieur> getInterieur()
    {
        return InterieurService.getInterieur();
    }

    @GetMapping("/Interieur/{id}")
    public Interieur getInterieur(@PathVariable long id){
        return InterieurService.getInterieurById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Interieur")
    public Interieur addInterieur(@RequestBody Interieur Interieur){
        return InterieurService.save(Interieur);
    }
    @PutMapping("/Interieur/{id}")
    public ResponseEntity<?> addInterieur(@RequestBody Interieur Interieur , @PathVariable Long id){
        if( InterieurService.existById(id)){
            Interieur Interieur1 =InterieurService.getInterieurById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
               Interieur1.setType(Interieur.getType());
            //Interieur1.setEtat(Interieur.getEtat());

            InterieurService.save(Interieur);
            return ResponseEntity.ok().body(Interieur1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Interieur/{id}")
    public ResponseEntity<?> deleteInterieur(@RequestBody Interieur Interieur ,@PathVariable Long id){
        if( InterieurService.existById(id)){
            InterieurService.deleteInterieur(id);
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
