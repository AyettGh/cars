package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Exterieur;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExterieurRepository extends JpaRepository<Exterieur,Long> {
}
