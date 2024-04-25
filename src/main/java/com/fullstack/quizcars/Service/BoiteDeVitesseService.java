package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.Repository.BoiteDeVitesseRepository;
import com.fullstack.quizcars.classes.BoiteDeVitesse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoiteDeVitesseService {
    @Autowired
    private BoiteDeVitesseRepository BoiteDeVitesseRepository;

    public  List<BoiteDeVitesse> getBoiteDeVitesse() {
        return BoiteDeVitesseRepository.findAll();
    }

    public  Optional<BoiteDeVitesse> getBoiteDeVitesseById(Long id){
        return BoiteDeVitesseRepository.findById(id);
    }

    public  BoiteDeVitesse save(BoiteDeVitesse BoiteDeVitesse){return BoiteDeVitesseRepository.saveAndFlush(BoiteDeVitesse);}
    public  boolean existById(Long id){ return BoiteDeVitesseRepository.existsById(id);}
    public  void deleteBoiteDeVitesse(Long id){
        BoiteDeVitesseRepository.deleteById(id);
    }
}
