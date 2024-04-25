package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.CircuitVehicule;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CircuitVehiculeService {
    @Autowired
    private com.fullstack.quizcars.Repository.CircuitVehiculeRepository CircuitVehiculeRepository;

    public List<CircuitVehicule> getCircuitVehicule() {
        return CircuitVehiculeRepository.findAll();
    }

    public Optional<CircuitVehicule> getCircuitVehiculeById(Long id){
        return CircuitVehiculeRepository.findById(id);
    }

    public  CircuitVehicule save(CircuitVehicule CircuitVehicule){
        return CircuitVehiculeRepository.saveAndFlush(CircuitVehicule);}
    public  boolean existById(Long id){ return CircuitVehiculeRepository.existsById(id);}
    public  void deleteCircuitVehicule(Long id){
        CircuitVehiculeRepository.deleteById(id);
    }
}
