package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.DateCirculation;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateCirculationRepository extends JpaRepository<DateCirculation,Long> {
}
