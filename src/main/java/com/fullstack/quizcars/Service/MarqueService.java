package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.Marque;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MarqueService {
    @Autowired
    private com.fullstack.quizcars.Repository.MarqueRepository MarqueRepository;

    public List<Marque> getMarque() {
        return MarqueRepository.findAll();
    }

    public Optional<Marque> getMarqueById(Long id){
        return MarqueRepository.findById(id);
    }

    public  Marque save(Marque Marque){
        return MarqueRepository.saveAndFlush(Marque);}
    public  boolean existById(Long id){ return MarqueRepository.existsById(id);}
    public  void deleteMarque(Long id){
        MarqueRepository.deleteById(id);
    }
}
