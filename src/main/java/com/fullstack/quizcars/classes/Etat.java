package com.fullstack.quizcars.classes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;

    @OneToOne(mappedBy = "etat")
    private CircuitVehicule circuitVehicule;

    @OneToOne(mappedBy = "etat")
    private ConsommationHuile consommationHuile;

    @OneToOne(mappedBy = "etat")
    private DateCirculation dateCirculation;

    @OneToOne(mappedBy = "etat")
    private DateDeFabrication dateDeFabrication;

    @OneToOne(mappedBy = "etat")
    private Entretien entretien;

    @OneToOne(mappedBy = "etat")
    private EtatAccidentée etatAccidente;

    @OneToOne(mappedBy = "etat")
    private EtatGeneral etatGeneral;

    @OneToOne(mappedBy = "etat")
    private Exterieur exterieur;

    @OneToOne(mappedBy = "etat")
    private Interieur interieur;

    @OneToOne(mappedBy = "etat")
    private Kilometre kilometre;

    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    private Proprietaire proprietaire;
}
