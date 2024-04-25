package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.BoiteDeVitesse;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoiteDeVitesseRepository extends JpaRepository<BoiteDeVitesse,Long> {
}
