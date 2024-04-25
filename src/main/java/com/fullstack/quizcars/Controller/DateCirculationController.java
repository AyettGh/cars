package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.classes.DateCirculation;
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
public class DateCirculationController {
    @Autowired

    private com.fullstack.quizcars.Service.DateCirculationService DateCirculationService;
    @GetMapping("/DateCirculation")
    public List<DateCirculation> getDateCirculation()
    {
        return DateCirculationService.getDateCirculation();
    }

    @GetMapping("/DateCirculation/{id}")
    public DateCirculation getDateCirculation(@PathVariable long id){
        return DateCirculationService.getDateCirculationById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/DateCirculation")
    public DateCirculation addDateCirculation(@RequestBody DateCirculation DateCirculation){
        return DateCirculationService.save(DateCirculation);
    }
    @PutMapping("/DateCirculation/{id}")
    public ResponseEntity<?> addDateCirculation(@RequestBody DateCirculation DateCirculation , @PathVariable Long id){
        if( DateCirculationService.existById(id)){
            DateCirculation DateCirculation1 =DateCirculationService.getDateCirculationById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
            //   DateCirculation1.setType(DateCirculation.getType());
            //DateCirculation1.setDateCirculations(DateCirculation.getDateCirculations());

            DateCirculationService.save(DateCirculation);
            return ResponseEntity.ok().body(DateCirculation1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/DateCirculation/{id}")
    public ResponseEntity<?> deleteDateCirculation(@RequestBody DateCirculation DateCirculation ,@PathVariable Long id){
        if( DateCirculationService.existById(id)){
            DateCirculationService.deleteDateCirculation(id);
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
