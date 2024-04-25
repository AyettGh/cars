package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.Etat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtatService {
    @Autowired
    private com.fullstack.quizcars.Repository.EtatRepository EtatRepository;

    public List<Etat> getEtat() {
        return EtatRepository.findAll();
    }

    public Optional<Etat> getEtatById(Long id){
        return EtatRepository.findById(id);
    }

    public  Etat save(Etat Etat){
        return EtatRepository.saveAndFlush(Etat);}
    public  boolean existById(Long id){ return EtatRepository.existsById(id);}
    public  void deleteEtat(Long id){
        EtatRepository.deleteById(id);
    }
}
