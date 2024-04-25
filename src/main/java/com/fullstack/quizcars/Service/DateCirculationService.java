package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.DateCirculation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DateCirculationService {
    @Autowired
    private com.fullstack.quizcars.Repository.DateCirculationRepository DateCirculationRepository;

    public List<DateCirculation> getDateCirculation() {
        return DateCirculationRepository.findAll();
    }

    public Optional<DateCirculation> getDateCirculationById(Long id){
        return DateCirculationRepository.findById(id);
    }

    public  DateCirculation save(DateCirculation DateCirculation){
        return DateCirculationRepository.saveAndFlush(DateCirculation);}
    public  boolean existById(Long id){ return DateCirculationRepository.existsById(id);}
    public  void deleteDateCirculation(Long id){
        DateCirculationRepository.deleteById(id);
    }
}
