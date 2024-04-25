package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.Service.ModeleService;
import com.fullstack.quizcars.Service.VersionService;
import com.fullstack.quizcars.classes.Modele;
import com.fullstack.quizcars.classes.Version;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/q")
public class VersionController {
    @Autowired

    private com.fullstack.quizcars.Service.VersionService VersionService;
    ModeleService ModeleService;

    @GetMapping("/Version/Modele/{ModeleId}")
    public List<Version> getVersionByModele(@PathVariable Long ModeleId) {
        return VersionService.getVersionByModele(ModeleId);
    }

    @GetMapping("/Version/{id}")
    public Version getVersion(@PathVariable long id){
        return VersionService.getVersionById(id).orElseThrow(
                ()->new EntityNotFoundException("entity not found")
        );
    }
    @PostMapping("/Version/{ModeleId}")
    public Version addVersion(@RequestBody Version Version, @PathVariable Long ModeleId) {
        Modele Modele = ModeleService.getModeleById(ModeleId).orElseThrow(
                () -> new EntityNotFoundException("Modele not found")
        );
        Version.setModele(Modele);
        return VersionService.save(Version);
    }
    @PutMapping("/Version/{id}")
    public ResponseEntity<?> updateVersion(@RequestBody Version Version , @PathVariable Long id){
        if( VersionService.existById(id)){
            Version Version1 =VersionService.getVersionById(id).orElseThrow(
                    ()-> new EntityNotFoundException("erreur")
            );
            Version1.setName(Version.getName());
            //Version1.setVersions(Version.getVersions());
            //Version1.setModele(Version.getModele());

            VersionService.save(Version);
            return ResponseEntity.ok().body(Version1);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @DeleteMapping("/Version/{id}")
    public ResponseEntity<?> deleteVersion(@RequestBody Version Version ,@PathVariable Long id){
        if( VersionService.existById(id)){
            VersionService.deleteVersion(id);
            HashMap<String,String> message=new HashMap<>();
            message.put("message",id+"deleted");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        else {
            HashMap<String,String> message = new HashMap<>();
            message.put("message",id+"task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
