package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.Service.MarqueService;
import com.fullstack.quizcars.classes.Marque;
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
public class MarqueController {
    @Autowired

    private com.fullstack.quizcars.Service.MarqueService MarqueService;
    @GetMapping("/Marque")
    public List<Marque> getMarque()
    {
        return MarqueService.getMarque();
    }

    @GetMapping("/Marque/{id}")
    public Marque getMarque(@PathVariable long id){
        return MarqueService.getMarqueById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Marque")
    public Marque addMarque(@RequestBody Marque Marque){
        return MarqueService.save(Marque);
    }
    @PutMapping("/Marque/{id}")
    public ResponseEntity<?> addMarque(@RequestBody Marque Marque , @PathVariable Long id){
        if( MarqueService.existById(id)){
            Marque Marque1 =MarqueService.getMarqueById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
            Marque1.setName(Marque.getName());
            //Marque1.setMarques(Marque.getMarques());

            MarqueService.save(Marque);
            return ResponseEntity.ok().body(Marque1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Marque/{id}")
    public ResponseEntity<?> deleteMarque(@RequestBody Marque Marque ,@PathVariable Long id){
        if( MarqueService.existById(id)){
            MarqueService.deleteMarque(id);
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
