package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.Caracterstique;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CaracterstiqueService {
    @Autowired
    private com.fullstack.quizcars.Repository.CaracterstiqueRepository CaracterstiqueRepository;

    public List<Caracterstique> getCaracterstique() {
        return CaracterstiqueRepository.findAll();
    }

    public Optional<Caracterstique> getCaracterstiqueById(Long id){
        return CaracterstiqueRepository.findById(id);
    }

    public  Caracterstique save(Caracterstique Caracterstique){
        return CaracterstiqueRepository.saveAndFlush(Caracterstique);}
    public  boolean existById(Long id){ return CaracterstiqueRepository.existsById(id);}
    public  void deleteCaracterstique(Long id){
        CaracterstiqueRepository.deleteById(id);
    }
    
}
