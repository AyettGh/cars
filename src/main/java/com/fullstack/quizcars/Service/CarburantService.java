package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.Carburant;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarburantService {
    @Autowired
    private com.fullstack.quizcars.Repository.CarburantRepository CarburantRepository;

    public List<Carburant> getCarburant() {
        return CarburantRepository.findAll();
    }

    public Optional<Carburant> getCarburantById(Long id){
        return CarburantRepository.findById(id);
    }

    public  Carburant save(Carburant Carburant){
        return CarburantRepository.saveAndFlush(Carburant);}
    public  boolean existById(Long id){ return CarburantRepository.existsById(id);}
    public  void deleteCarburant(Long id){
        CarburantRepository.deleteById(id);
    }
}
