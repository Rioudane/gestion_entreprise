package ma.ensa.infosat.gestion_entreprise.base;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensa.infosat.gestion_entreprise.inheritance.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,length = 4)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "class")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "Banque",value= Banque.class),
        @JsonSubTypes.Type(name = "Etablissement",value= Etablissement.class),
        @JsonSubTypes.Type(name = "Fonction",value= Fonction.class),
        @JsonSubTypes.Type(name = "IntituleDiplome",value= IntituleDiplome.class),
        @JsonSubTypes.Type(name = "Langue",value= Langue.class),
        @JsonSubTypes.Type(name = "MotifDepart",value= MotifDepart.class),
        @JsonSubTypes.Type(name = "MotifEntree",value= MotifEntree.class),
        @JsonSubTypes.Type(name = "NiveauLangue",value= NiveauLangue.class),
        @JsonSubTypes.Type(name = "NiveauScolaire",value= NiveauScolaire.class),
        @JsonSubTypes.Type(name = "Organisme",value= Organisme.class),
        @JsonSubTypes.Type(name = "Qualification",value= Qualification.class),
        @JsonSubTypes.Type(name = "Specialite",value= Specialite.class),
        @JsonSubTypes.Type(name = "StatusProfessionel",value= StatusProfessionel.class),
        @JsonSubTypes.Type(name = "TypeAddresse",value= TypeAddresse.class),
        @JsonSubTypes.Type(name = "TypeContrat",value= TypeContrat.class),
        @JsonSubTypes.Type(name = "TypeDocument",value= TypeDocument.class),
        @JsonSubTypes.Type(name = "TypeEmail",value= TypeEmail.class),
        @JsonSubTypes.Type(name = "TypeRemunirationContrat",value= TypeRemunirationContrat.class),
        @JsonSubTypes.Type(name = "TypeReseauSocial",value= TypeReseauSocial.class),
        @JsonSubTypes.Type(name = "TypeTelephone",value= TypeTelephone.class),
        @JsonSubTypes.Type(name = "TypeOrganisme",value= TypeOrganisme.class),

})
public class BaseType {
    @Id @GeneratedValue
    private Long id ;
    private String description;
    private String nom;
}
