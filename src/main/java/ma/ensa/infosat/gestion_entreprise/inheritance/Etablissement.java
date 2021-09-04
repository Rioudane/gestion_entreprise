package ma.ensa.infosat.gestion_entreprise.inheritance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensa.infosat.gestion_entreprise.base.BaseType;
import ma.ensa.infosat.gestion_entreprise.entity.Diplome;
import ma.ensa.infosat.gestion_entreprise.entity.Pays;
import ma.ensa.infosat.gestion_entreprise.entity.Ville;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Etablis")
public class Etablissement extends BaseType implements Serializable {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "etablissement")
    private List<Diplome> diplomes;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Ville ville;
}
