package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Etat;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatRepository extends JpaRepository<Etat,Long> {
}
