package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.Modele;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeleService {
    @Autowired
    private com.fullstack.quizcars.Repository.ModeleRepository ModeleRepository;

    public List<Modele> getModeleByMarque(Long id_marque) {
        return ModeleRepository.getAllModele(id_marque);
    }

    public Optional<Modele> getModeleById(Long id){
        return ModeleRepository.findById(id);
    }

    public  Modele save(Modele Modele){
        return ModeleRepository.saveAndFlush(Modele);}
    public  boolean existById(Long id){ return ModeleRepository.existsById(id);}
    public  void deleteModele(Long id){
        ModeleRepository.deleteById(id);
    }
}
