package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Proprietaire;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropietaireRepository extends JpaRepository<Proprietaire,Long> {
}
