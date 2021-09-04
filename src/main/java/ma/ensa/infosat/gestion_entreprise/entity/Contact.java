package ma.ensa.infosat.gestion_entreprise.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensa.infosat.gestion_entreprise.inheritance.NiveauScolaire;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,length = 3)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "visiteur")
@JsonSubTypes( {
        @JsonSubTypes.Type(name="collaborateur",value = Collaborateur.class)
})
public class Contact implements Serializable  , UserDetails {
    @Id
    @GeneratedValue
    private  Long id;
    private  String nom;
    private  String prenom;
    @Enumerated(EnumType.STRING)
    private SexeEnum sexe;
    @Enumerated(EnumType.STRING)
    private CiviliteEnum civilite;
    private Date dateNaissance;
    private  String cin;
    @Enumerated(EnumType.STRING)
    private SituationFamilialeEnum situationFamiliale;
    private boolean permisConduire;
    private  String photo;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private AppUserRole visiteur;
    private  Boolean locked=false;
    private Boolean enabled=false;

    public Contact(String nom, String prenom, SexeEnum sexe, CiviliteEnum civilite, Date dateNaissance, String cin, SituationFamilialeEnum situationFamiliale, boolean permisConduire, String photo, String password, String email, AppUserRole visiteur, List<ReseauSocial> reseauSocials, List<Telephone> telephones, List<Email> emails, List<Document> documents, List<Addresse> addresses, List<LangueContact> langueContacts, List<Diplome> diplomes, NiveauScolaire niveauScolaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.civilite = civilite;
        this.dateNaissance = dateNaissance;
        this.cin = cin;
        this.situationFamiliale = situationFamiliale;
        this.permisConduire = permisConduire;
        this.photo = photo;
        this.password = password;
        this.email = email;
        this.visiteur = visiteur;
        this.locked = locked;
        this.enabled = enabled;
        this.reseauSocials = reseauSocials;
        this.telephones = telephones;
        this.emails = emails;
        this.documents = documents;
        this.addresses = addresses;
        this.langueContacts = langueContacts;
        this.diplomes = diplomes;
        this.niveauScolaire = niveauScolaire;
    }

    public enum CiviliteEnum{
        Marocaine,
        Etranger
    }
    public enum SexeEnum {
        Masculin,
        Feminin
    }
    public  enum SituationFamilialeEnum{
        Marrié,
        célibataire
    }



    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ReseauSocial> reseauSocials;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Telephone> telephones;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Email> emails ;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Document> documents;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Addresse> addresses;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<LangueContact> langueContacts;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Diplome> diplomes;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private NiveauScolaire niveauScolaire;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority=new SimpleGrantedAuthority(visiteur.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


}
