package ma.ensa.infosat.gestion_entreprise.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@DiscriminatorValue("collab")
public class Collaborateur extends Contact implements Serializable {

private  boolean compteActive;



    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "collaborateur",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CoordonneesBanquaire> coordonneesBanquaires;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "collaborateur",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<InformationsOrganisme> informationsOrganismes;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "collaborateur",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Contrat> contrats;



}

