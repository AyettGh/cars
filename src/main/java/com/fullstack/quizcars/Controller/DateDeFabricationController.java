package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.classes.DateDeFabrication;
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
public class DateDeFabricationController {
    @Autowired

    private com.fullstack.quizcars.Service.DateDeFabricationService DateDeFabricationService;
    @GetMapping("/DateDeFabrication")
    public List<DateDeFabrication> getDateDeFabrication()
    {
        return DateDeFabricationService.getDateDeFabrication();
    }

    @GetMapping("/DateDeFabrication/{id}")
    public DateDeFabrication getDateDeFabrication(@PathVariable long id){
        return DateDeFabricationService.getDateDeFabricationById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/DateDeFabrication")
    public DateDeFabrication addDateDeFabrication(@RequestBody DateDeFabrication DateDeFabrication){
        return DateDeFabricationService.save(DateDeFabrication);
    }
    @PutMapping("/DateDeFabrication/{id}")
    public ResponseEntity<?> addDateDeFabrication(@RequestBody DateDeFabrication DateDeFabrication , @PathVariable Long id){
        if( DateDeFabricationService.existById(id)){
            DateDeFabrication DateDeFabrication1 =DateDeFabricationService.getDateDeFabricationById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
              DateDeFabrication1.setType(DateDeFabrication.getType());
            //DateDeFabrication1.setEtat(DateDeFabrication.getEtat());

            DateDeFabricationService.save(DateDeFabrication);
            return ResponseEntity.ok().body(DateDeFabrication1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/DateDeFabrication/{id}")
    public ResponseEntity<?> deleteDateDeFabrication(@RequestBody DateDeFabrication DateDeFabrication ,@PathVariable Long id){
        if( DateDeFabricationService.existById(id)){
            DateDeFabricationService.deleteDateDeFabrication(id);
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
