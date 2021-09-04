package ma.ensa.infosat.gestion_entreprise.inheritance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensa.infosat.gestion_entreprise.base.BaseType;
import ma.ensa.infosat.gestion_entreprise.entity.Addresse;
import ma.ensa.infosat.gestion_entreprise.entity.InformationsOrganisme;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Organis")
public class Organisme  extends BaseType implements Serializable {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "organisme")
    private List<InformationsOrganisme> informationsOrganismes;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private TypeOrganisme typeOrganisme;
}
