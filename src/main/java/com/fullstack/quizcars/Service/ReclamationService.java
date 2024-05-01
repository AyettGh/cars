package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.Repository.ReclamationRepository;
import com.fullstack.quizcars.classes.Interieur;
import com.fullstack.quizcars.classes.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationService {
    @Autowired

    private com.fullstack.quizcars.Repository.ReclamationRepository reclamationRepository;

    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    public Reclamation saveReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }
}
