package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Kilometre;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KilometreRepository extends JpaRepository<Kilometre,Long> {
}
