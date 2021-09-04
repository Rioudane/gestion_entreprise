package ma.ensa.infosat.gestion_entreprise.inheritance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensa.infosat.gestion_entreprise.base.BaseType;
import ma.ensa.infosat.gestion_entreprise.entity.Contrat;
import ma.ensa.infosat.gestion_entreprise.entity.RemunirationContrat;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("TypeC")
public class TypeContrat extends BaseType implements Serializable {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "typeContrat")
    private List<Contrat> contrats;
}
