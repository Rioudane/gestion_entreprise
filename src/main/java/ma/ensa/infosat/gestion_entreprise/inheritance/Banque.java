package ma.ensa.infosat.gestion_entreprise.inheritance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensa.infosat.gestion_entreprise.base.BaseType;
import ma.ensa.infosat.gestion_entreprise.entity.CoordonneesBanquaire;
import ma.ensa.infosat.gestion_entreprise.entity.Diplome;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Banque")

public class Banque  extends BaseType implements Serializable {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "banque",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CoordonneesBanquaire> coordonneesBanquaires;
}
