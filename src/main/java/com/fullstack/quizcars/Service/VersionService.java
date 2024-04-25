package com.fullstack.quizcars.Service;

import com.fullstack.quizcars.classes.Version;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VersionService {
    @Autowired
    private com.fullstack.quizcars.Repository.VersionRepository VersionRepository;

    public List<Version> getVersionByModele(Long id_modele) {
        return VersionRepository.getAllVersion(id_modele);
    }

    public Optional<Version> getVersionById(Long id){
        return VersionRepository.findById(id);
    }

    public  Version save(Version Version){
        return VersionRepository.saveAndFlush(Version);}
    public  boolean existById(Long id){ return VersionRepository.existsById(id);}
    public  void deleteVersion(Long id){
        VersionRepository.deleteById(id);
    }
}
