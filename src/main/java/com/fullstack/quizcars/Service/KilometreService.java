package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.Kilometre;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KilometreService {
    @Autowired
    private com.fullstack.quizcars.Repository.KilometreRepository KilometreRepository;

    public List<Kilometre> getKilometre() {
        return KilometreRepository.findAll();
    }

    public Optional<Kilometre> getKilometreById(Long id){
        return KilometreRepository.findById(id);
    }

    public  Kilometre save(Kilometre Kilometre){
        return KilometreRepository.saveAndFlush(Kilometre);}
    public  boolean existById(Long id){ return KilometreRepository.existsById(id);}
    public  void deleteKilometre(Long id){
        KilometreRepository.deleteById(id);
    }
}
