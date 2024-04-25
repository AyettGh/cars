package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.Exterieur;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExterieurService {
    @Autowired
    private com.fullstack.quizcars.Repository.ExterieurRepository ExterieurRepository;

    public List<Exterieur> getExterieur() {
        return ExterieurRepository.findAll();
    }

    public Optional<Exterieur> getExterieurById(Long id){
        return ExterieurRepository.findById(id);
    }

    public  Exterieur save(Exterieur Exterieur){
        return ExterieurRepository.saveAndFlush(Exterieur);}
    public  boolean existById(Long id){ return ExterieurRepository.existsById(id);}
    public  void deleteExterieur(Long id){
        ExterieurRepository.deleteById(id);
    }
}
