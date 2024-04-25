package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.classes.Carburant;
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
public class CarburantController {
    @Autowired

    private com.fullstack.quizcars.Service.CarburantService CarburantService;
    @GetMapping("/Carburant")
    public List<Carburant> getCarburant()
    {
        return CarburantService.getCarburant();
    }

    @GetMapping("/Carburant/{id}")
    public Carburant getCarburant(@PathVariable long id){
        return CarburantService.getCarburantById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Carburant")
    public Carburant addCarburant(@RequestBody Carburant Carburant){
        return CarburantService.save(Carburant);
    }
    @PutMapping("/Carburant/{id}")
    public ResponseEntity<?> addCarburant(@RequestBody Carburant Carburant , @PathVariable Long id){
        if( CarburantService.existById(id)){
            Carburant Carburant1 =CarburantService.getCarburantById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
               Carburant1.setType(Carburant.getType());

            CarburantService.save(Carburant);
            return ResponseEntity.ok().body(Carburant1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Carburant/{id}")
    public ResponseEntity<?> deleteCarburant(@RequestBody Carburant Carburant ,@PathVariable Long id){
        if( CarburantService.existById(id)){
            CarburantService.deleteCarburant(id);
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
