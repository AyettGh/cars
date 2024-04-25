package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.classes.EtatGeneral;
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
public class EtatGeneralController {
    @Autowired

    private com.fullstack.quizcars.Service.EtatGeneralService EtatGeneralService;
    @GetMapping("/EtatGeneral")
    public List<EtatGeneral> getEtatGeneral()
    {
        return EtatGeneralService.getEtatGeneral();
    }

    @GetMapping("/EtatGeneral/{id}")
    public EtatGeneral getEtatGeneral(@PathVariable long id){
        return EtatGeneralService.getEtatGeneralById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/EtatGeneral")
    public EtatGeneral addEtatGeneral(@RequestBody EtatGeneral EtatGeneral){
        return EtatGeneralService.save(EtatGeneral);
    }
    @PutMapping("/EtatGeneral/{id}")
    public ResponseEntity<?> addEtatGeneral(@RequestBody EtatGeneral EtatGeneral , @PathVariable Long id){
        if( EtatGeneralService.existById(id)){
            EtatGeneral EtatGeneral1 =EtatGeneralService.getEtatGeneralById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
            EtatGeneral1.setType(EtatGeneral.getType());
            //EtatGeneral1.setEtat(EtatGeneral.getEtat());
            EtatGeneralService.save(EtatGeneral);
            return ResponseEntity.ok().body(EtatGeneral1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/EtatGeneral/{id}")
    public ResponseEntity<?> deleteEtatGeneral(@RequestBody EtatGeneral EtatGeneral ,@PathVariable Long id){
        if( EtatGeneralService.existById(id)){
            EtatGeneralService.deleteEtatGeneral(id);
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
