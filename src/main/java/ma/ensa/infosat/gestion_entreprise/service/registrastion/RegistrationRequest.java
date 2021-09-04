package ma.ensa.infosat.gestion_entreprise.service.registrastion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ma.ensa.infosat.gestion_entreprise.entity.*;
import ma.ensa.infosat.gestion_entreprise.inheritance.NiveauScolaire;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private  String prenom;
    private  String nom;
    private  String email;
    private  String password;
    private Contact.SexeEnum sexe;
    private Contact.CiviliteEnum civilite;
    private Date dateNaissance;
    private  String cin;
    private Contact.SituationFamilialeEnum situationFamiliale;
    private boolean permisConduire;
    private  String photo;
    private AppUserRole visiteur;
    private  Boolean locked;
    private Boolean enabled;
    private List<ReseauSocial> reseauSocials;
    private List<Telephone> telephones;
    private List<Email> emails ;
    private List<Document> documents;
    private List<Addresse> addresses;
    private List<LangueContact> langueContacts;
    private List<Diplome> diplomes;
    private NiveauScolaire niveauScolaire;
}
