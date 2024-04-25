package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.classes.Etat;
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
public class EtatController {
    @Autowired

    private com.fullstack.quizcars.Service.EtatService EtatService;
    @GetMapping("/Etat")
    public List<Etat> getEtat()
    {
        return EtatService.getEtat();
    }

    @GetMapping("/Etat/{id}")
    public Etat getEtat(@PathVariable long id){
        return EtatService.getEtatById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Etat")
    public Etat addEtat(@RequestBody Etat Etat){
        return EtatService.save(Etat);
    }
    @PutMapping("/Etat/{id}")
    public ResponseEntity<?> addEtat(@RequestBody Etat Etat , @PathVariable Long id){
        if( EtatService.existById(id)){
            Etat Etat1 =EtatService.getEtatById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
              Etat1.setState(Etat.getState());
//            Etat1.setEtatAccidente(Etat.getEtatAccidente());
//            Etat1.setEtatGeneral(Etat.getEtatGeneral());
//            Etat1.setEntretien(Etat.getEntretien());
//            Etat1.setExterieur(Etat.getExterieur());
//            Etat1.setInterieur(Etat.getInterieur());
//            Etat1.setCircuitVehicule(Etat.getCircuitVehicule());
//            Etat1.setConsommationHuile(Etat.getConsommationHuile());
//            Etat1.setDateCirculation(Etat.getDateCirculation());
//            Etat1.setDateDeFabrication(Etat.getDateDeFabrication());
//            Etat1.setKilometre(Etat.getKilometre());
//            Etat1.setProprietaire(Etat.getProprietaire());


            EtatService.save(Etat);
            return ResponseEntity.ok().body(Etat1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Etat/{id}")
    public ResponseEntity<?> deleteEtat(@RequestBody Etat Etat ,@PathVariable Long id){
        if( EtatService.existById(id)){
            EtatService.deleteEtat(id);
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
