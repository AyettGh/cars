package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Carburant;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarburantRepository extends JpaRepository<Carburant,Long> {
}
