package ma.ensa.infosat.gestion_entreprise.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensa.infosat.gestion_entreprise.inheritance.Etablissement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ville  implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  String nom ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Pays pays;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "ville",cascade = CascadeType.ALL)
    private List<Addresse> addresses;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "ville",cascade = CascadeType.ALL)
    private List<Etablissement> etablissements;

}
