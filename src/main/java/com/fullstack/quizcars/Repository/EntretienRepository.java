package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Entretien;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntretienRepository extends JpaRepository<Entretien,Long> {
}
