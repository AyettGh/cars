package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.ConsommationHuile;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsommationHuileService {
    @Autowired
    private com.fullstack.quizcars.Repository.ConsommationRepository ConsommationHuileRepository;

    public List<ConsommationHuile> getConsommationHuile() {
        return ConsommationHuileRepository.findAll();
    }

    public Optional<ConsommationHuile> getConsommationHuileById(Long id){
        return ConsommationHuileRepository.findById(id);
    }

    public  ConsommationHuile save(ConsommationHuile ConsommationHuile){
        return ConsommationHuileRepository.saveAndFlush(ConsommationHuile);}
    public  boolean existById(Long id){ return ConsommationHuileRepository.existsById(id);}
    public  void deleteConsommationHuile(Long id){
        ConsommationHuileRepository.deleteById(id);
    }
}
