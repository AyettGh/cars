package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Caracterstique;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaracterstiqueRepository extends JpaRepository<Caracterstique,Long> {
}
