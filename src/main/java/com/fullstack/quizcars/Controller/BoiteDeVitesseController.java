package com.fullstack.quizcars.Controller;
import com.fullstack.quizcars.Service.BoiteDeVitesseService;
import com.fullstack.quizcars.classes.BoiteDeVitesse;
import com.fullstack.quizcars.classes.BoiteDeVitesse;
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
public class BoiteDeVitesseController {
    @Autowired

    private com.fullstack.quizcars.Service.BoiteDeVitesseService BoiteDeVitesseService;
    @GetMapping("/BoiteDeVitesse")
    public List<BoiteDeVitesse> getBoiteDeVitesse()
    {
        return BoiteDeVitesseService.getBoiteDeVitesse();
    }

    @GetMapping("/BoiteDeVitesse/{id}")
    public BoiteDeVitesse getBoiteDeVitesse(@PathVariable long id){
        return BoiteDeVitesseService.getBoiteDeVitesseById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/BoiteDeVitesse")
    public BoiteDeVitesse addBoiteDeVitesse(@RequestBody BoiteDeVitesse BoiteDeVitesse){
        return BoiteDeVitesseService.save(BoiteDeVitesse);
    }
    @PutMapping("/BoiteDeVitesse/{id}")
    public ResponseEntity<?> addBoiteDeVitesse(@RequestBody BoiteDeVitesse BoiteDeVitesse , @PathVariable Long id){
        if( BoiteDeVitesseService.existById(id)){
            BoiteDeVitesse BoiteDeVitesse1 =BoiteDeVitesseService.getBoiteDeVitesseById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
            BoiteDeVitesse1.setType(BoiteDeVitesse.getType());
            //BoiteDeVitesse1.setBoiteDeVitesses(BoiteDeVitesse.getBoiteDeVitesses());

            BoiteDeVitesseService.save(BoiteDeVitesse);
            return ResponseEntity.ok().body(BoiteDeVitesse1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/BoiteDeVitesse/{id}")
    public ResponseEntity<?> deleteBoiteDeVitesse(@RequestBody BoiteDeVitesse BoiteDeVitesse ,@PathVariable Long id){
        if( BoiteDeVitesseService.existById(id)){
            BoiteDeVitesseService.deleteBoiteDeVitesse(id);
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
