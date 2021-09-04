package ma.ensa.infosat.gestion_entreprise.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensa.infosat.gestion_entreprise.inheritance.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrat implements Serializable {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id ;
    private Date dateDebut;
    private Date dateFin;
    private Date dateDepart;
    private  int periodeEssai1;
    private  int periodeEssai2;
    private  String ancieneteAjoutee;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Collaborateur collaborateur;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Fonction fonction;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private MotifEntree motifEntree;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private MotifDepart motifDepart;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private TypeContrat typeContrat;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Qualification qualification;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private StatusProfessionel statusProfessionel;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "contrat",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<RemunirationContrat> remunirationContrats;
}
