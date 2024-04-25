package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.EtatGeneral;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatGeneralRepository extends JpaRepository<EtatGeneral,Long> {
}
