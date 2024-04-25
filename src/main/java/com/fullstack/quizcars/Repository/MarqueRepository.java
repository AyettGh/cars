package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Marque;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MarqueRepository extends JpaRepository<Marque,Long> {
  //  @Query(value = "select * from  order by due_date desc", nativeQuery = true)

}
