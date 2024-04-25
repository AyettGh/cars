package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.classes.Caracterstique;
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
public class CaracterstiqueController {
    @Autowired

    private com.fullstack.quizcars.Service.CaracterstiqueService CaracterstiqueService;
    @GetMapping("/Caracterstique")
    public List<Caracterstique> getCaracterstique()
    {
        return CaracterstiqueService.getCaracterstique();
    }

    @GetMapping("/Caracterstique/{id}")
    public Caracterstique getCaracterstique(@PathVariable long id){
        return CaracterstiqueService.getCaracterstiqueById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Caracterstique")
    public Caracterstique addCaracterstique(@RequestBody Caracterstique Caracterstique){
        return CaracterstiqueService.save(Caracterstique);
    }
    @PutMapping("/Caracterstique/{id}")
    public ResponseEntity<?> addCaracterstique(@RequestBody Caracterstique Caracterstique , @PathVariable Long id){
        if( CaracterstiqueService.existById(id)){
            Caracterstique Caracterstique1 =CaracterstiqueService.getCaracterstiqueById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
             Caracterstique1.setVersion(Caracterstique.getVersion());
//             Caracterstique1.setEtat(Caracterstique.getEtat());
//            Caracterstique1.setBoiteVitesse(Caracterstique.getBoiteVitesse());
//            Caracterstique1.setCarburant(Caracterstique.getCarburant());

            CaracterstiqueService.save(Caracterstique);
            return ResponseEntity.ok().body(Caracterstique1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Caracterstique/{id}")
    public ResponseEntity<?> deleteCaracterstique(@RequestBody Caracterstique Caracterstique ,@PathVariable Long id){
        if( CaracterstiqueService.existById(id)){
            CaracterstiqueService.deleteCaracterstique(id);
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
