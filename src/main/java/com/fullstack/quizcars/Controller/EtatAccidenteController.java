package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.classes.EtatAccidentée;
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
public class EtatAccidenteController {
    @Autowired

    private com.fullstack.quizcars.Service.EtatAccidenteeService EtatAccidentéeService;
    @GetMapping("/EtatAccidentée")
    public List<EtatAccidentée> getEtatAccidentée()
    {
        return EtatAccidentéeService.getEtatAccidentee();
    }

    @GetMapping("/EtatAccidentée/{id}")
    public EtatAccidentée getEtatAccidentée(@PathVariable long id){
        return EtatAccidentéeService.getEtatAccidenteeById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/EtatAccidentée")
    public EtatAccidentée addEtatAccidentée(@RequestBody EtatAccidentée EtatAccidentée){
        return EtatAccidentéeService.save(EtatAccidentée);
    }
    @PutMapping("/EtatAccidentée/{id}")
    public ResponseEntity<?> addEtatAccidentée(@RequestBody EtatAccidentée EtatAccidentée , @PathVariable Long id){
        if( EtatAccidentéeService.existById(id)){
            EtatAccidentée EtatAccidentée1 =EtatAccidentéeService.getEtatAccidenteeById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
              EtatAccidentée1.setType(EtatAccidentée.getType());
            EtatAccidentée1.setEtat(EtatAccidentée.getEtat());

            EtatAccidentéeService.save(EtatAccidentée);
            return ResponseEntity.ok().body(EtatAccidentée1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/EtatAccidentée/{id}")
    public ResponseEntity<?> deleteEtatAccidentée(@RequestBody EtatAccidentée EtatAccidentée ,@PathVariable Long id){
        if( EtatAccidentéeService.existById(id)){
            EtatAccidentéeService.deleteEtatAccidentee(id);
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
