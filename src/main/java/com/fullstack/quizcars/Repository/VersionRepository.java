package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.Modele;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VersionRepository extends JpaRepository<Version,Long> {
    @Query(value = "select name from Version where id=modele_id ", nativeQuery = true)
    List<Version> getAllVersion(Long id_modele);
}
