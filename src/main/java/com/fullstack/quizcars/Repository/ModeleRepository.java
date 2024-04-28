package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Modele;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModeleRepository extends JpaRepository<Modele,Long> {
    @Query(value = "select name from Modele where id=marque_id ", nativeQuery = true)
    List<Modele> getAllModele(Long id_marque);


}
