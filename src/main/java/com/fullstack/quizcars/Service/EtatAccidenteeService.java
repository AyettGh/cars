package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.EtatAccidentée;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtatAccidenteeService {
    @Autowired
    private com.fullstack.quizcars.Repository.EtatAccidenteeRepository EtatAccidenteeRepository;

    public List<EtatAccidentée> getEtatAccidentee() {
        return EtatAccidenteeRepository.findAll();
    }

    public Optional<EtatAccidentée> getEtatAccidenteeById(Long id){
        return EtatAccidenteeRepository.findById(id);
    }

    public  EtatAccidentée save(EtatAccidentée EtatAccidentee){
        return EtatAccidenteeRepository.saveAndFlush(EtatAccidentee);}
    public  boolean existById(Long id){ return EtatAccidenteeRepository.existsById(id);}
    public  void deleteEtatAccidentee(Long id){
        EtatAccidenteeRepository.deleteById(id);
    }
}
