package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.DateDeFabrication;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DateDeFabricationService {
    @Autowired
    private com.fullstack.quizcars.Repository.DateDeFabricationRepository DateDeFabricationRepository;

    public List<DateDeFabrication> getDateDeFabrication() {
        return DateDeFabricationRepository.findAll();
    }

    public Optional<DateDeFabrication> getDateDeFabricationById(Long id){
        return DateDeFabricationRepository.findById(id);
    }

    public  DateDeFabrication save(DateDeFabrication DateDeFabrication){
        return DateDeFabricationRepository.saveAndFlush(DateDeFabrication);}
    public  boolean existById(Long id){ return DateDeFabricationRepository.existsById(id);}
    public  void deleteDateDeFabrication(Long id){
        DateDeFabricationRepository.deleteById(id);
    }
}
