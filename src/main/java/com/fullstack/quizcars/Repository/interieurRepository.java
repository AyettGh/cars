package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Interieur;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface interieurRepository extends JpaRepository<Interieur,Long> {
}
