package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.CircuitVehicule;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CircuitVehiculeRepository extends JpaRepository<CircuitVehicule,Long> {
}
