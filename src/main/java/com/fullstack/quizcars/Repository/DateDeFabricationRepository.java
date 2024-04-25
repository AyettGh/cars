package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.DateDeFabrication;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateDeFabricationRepository extends JpaRepository<DateDeFabrication,Long> {
}
