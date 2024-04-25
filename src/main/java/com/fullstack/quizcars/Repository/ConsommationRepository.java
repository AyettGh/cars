package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.ConsommationHuile;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsommationRepository extends JpaRepository<ConsommationHuile,Long> {
}
