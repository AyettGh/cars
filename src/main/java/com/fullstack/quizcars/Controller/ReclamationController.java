package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.Service.ReclamationService;
import com.fullstack.quizcars.classes.Reclamation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/q")
public class ReclamationController {
    private final ReclamationService reclamationService;

    @Autowired
    public ReclamationController(ReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }

    @GetMapping("/reclamation")
    public List<Reclamation> getReclamations() {
        return reclamationService.getAllReclamations();
    }

    @PostMapping("/reclamation")
    public Reclamation saveReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.saveReclamation(reclamation);
    }
}
