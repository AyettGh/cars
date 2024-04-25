package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.Proprietaire;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProprietaireService {
    @Autowired
    private com.fullstack.quizcars.Repository.PropietaireRepository PropietaireRepository;

    public List<Proprietaire> getProprietaire() {
        return PropietaireRepository.findAll();
    }

    public Optional<Proprietaire> getProprietaireById(Long id){
        return PropietaireRepository.findById(id);
    }

    public  Proprietaire save(Proprietaire Proprietaire){
        return PropietaireRepository.saveAndFlush(Proprietaire);}
    public  boolean existById(Long id){ return PropietaireRepository.existsById(id);}
    public  void deleteProprietaire(Long id){
        PropietaireRepository.deleteById(id);
    }
}
