package ma.ensa.infosat.gestion_entreprise.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensa.infosat.gestion_entreprise.inheritance.StatusProfessionel;
import ma.ensa.infosat.gestion_entreprise.inheritance.TypeContrat;
import ma.ensa.infosat.gestion_entreprise.inheritance.TypeRemunirationContrat;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemunirationContrat implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  double montant ;
    private  int periodicite ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Contrat contrat;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL)
    private TypeRemunirationContrat typeRemunirationContrat;
}
