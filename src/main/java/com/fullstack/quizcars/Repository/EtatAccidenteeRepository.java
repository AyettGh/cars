package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.EtatAccidentée;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatAccidenteeRepository extends JpaRepository<EtatAccidentée,Long> {
}
