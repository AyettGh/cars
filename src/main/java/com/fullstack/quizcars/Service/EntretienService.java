package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.Entretien;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EntretienService {
    @Autowired
    private com.fullstack.quizcars.Repository.EntretienRepository EntretienRepository;

    public List<Entretien> getEntretien() {
        return EntretienRepository.findAll();
    }

    public Optional<Entretien> getEntretienById(Long id){
        return EntretienRepository.findById(id);
    }

    public  Entretien save(Entretien Entretien){
        return EntretienRepository.saveAndFlush(Entretien);}
    public  boolean existById(Long id){ return EntretienRepository.existsById(id);}
    public  void deleteEntretien(Long id){
        EntretienRepository.deleteById(id);
    }
}
