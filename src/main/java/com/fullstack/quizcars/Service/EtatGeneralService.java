package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.EtatGeneral;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtatGeneralService {
    @Autowired
    private com.fullstack.quizcars.Repository.EtatGeneralRepository EtatGeneralRepository;

    public List<EtatGeneral> getEtatGeneral() {
        return EtatGeneralRepository.findAll();
    }

    public Optional<EtatGeneral> getEtatGeneralById(Long id){
        return EtatGeneralRepository.findById(id);
    }

    public  EtatGeneral save(EtatGeneral EtatGeneral){
        return EtatGeneralRepository.saveAndFlush(EtatGeneral);}
    public  boolean existById(Long id){ return EtatGeneralRepository.existsById(id);}
    public  void deleteEtatGeneral(Long id){
        EtatGeneralRepository.deleteById(id);
    }
}
