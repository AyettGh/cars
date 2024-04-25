package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.Interieur;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InterieurService {
    @Autowired
    private com.fullstack.quizcars.Repository.interieurRepository interieurRepository;

    public List<Interieur> getInterieur() {
        return interieurRepository.findAll();
    }

    public Optional<Interieur> getInterieurById(Long id){
        return interieurRepository.findById(id);
    }

    public  Interieur save(Interieur Interieur){
        return interieurRepository.saveAndFlush(Interieur);}
    public  boolean existById(Long id){ return interieurRepository.existsById(id);}
    public  void deleteInterieur(Long id){
        interieurRepository.deleteById(id);
    }
}
