package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.classes.CircuitVehicule;
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
public class CircuitVehiculeController {
    @Autowired

    private com.fullstack.quizcars.Service.CircuitVehiculeService CircuitVehiculeService;
    @GetMapping("/CircuitVehicule")
    public List<CircuitVehicule> getCircuitVehicule()
    {
        return CircuitVehiculeService.getCircuitVehicule();
    }

    @GetMapping("/CircuitVehicule/{id}")
    public CircuitVehicule getCircuitVehicule(@PathVariable long id){
        return CircuitVehiculeService.getCircuitVehiculeById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/CircuitVehicule")
    public CircuitVehicule addCircuitVehicule(@RequestBody CircuitVehicule CircuitVehicule){
        return CircuitVehiculeService.save(CircuitVehicule);
    }
    @PutMapping("/CircuitVehicule/{id}")
    public ResponseEntity<?> addCircuitVehicule(@RequestBody CircuitVehicule CircuitVehicule , @PathVariable Long id){
        if( CircuitVehiculeService.existById(id)){
            CircuitVehicule CircuitVehicule1 =CircuitVehiculeService.getCircuitVehiculeById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
               CircuitVehicule1.setType(CircuitVehicule.getType());
           // CircuitVehicule1.setEtat(CircuitVehicule.getEtat());

            CircuitVehiculeService.save(CircuitVehicule);
            return ResponseEntity.ok().body(CircuitVehicule1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/CircuitVehicule/{id}")
    public ResponseEntity<?> deleteCircuitVehicule(@RequestBody CircuitVehicule CircuitVehicule ,@PathVariable Long id){
        if( CircuitVehiculeService.existById(id)){
            CircuitVehiculeService.deleteCircuitVehicule(id);
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
