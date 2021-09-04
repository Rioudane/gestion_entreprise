package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.base.BaseType;
import ma.ensa.infosat.gestion_entreprise.entity.Ville;
import ma.ensa.infosat.gestion_entreprise.inheritance.TypeDocument;
import ma.ensa.infosat.gestion_entreprise.inheritance.TypeEmail;
import ma.ensa.infosat.gestion_entreprise.inheritance.TypeReseauSocial;
import ma.ensa.infosat.gestion_entreprise.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class BaseTypeInitServiceImpl implements BaseTypeInitService{




    @Autowired
    private VilleRepository villeRepository;



    @Autowired
    private BaseTypeRepository baseTypeRepository;




    @Override
    public void initTypeReseauSocials() {
        Stream.of("Twitter","Gmail","Facebook","Autres").forEach(
                name->{
                    TypeReseauSocial e=new TypeReseauSocial();
                    e.setNom(name);
                    baseTypeRepository.save(e);
                }
        );
    }

    @Override
    public void initVilles() {
        Stream.of("Casablanca","Agadir","Marrakech","Fes","Tanger","Rabat").forEach(
                nameVille->{
                    Ville v=new Ville();
                    v.setNom(nameVille);
                    villeRepository.save(v);
                }
        );

    }



    @Override
    public void initTypesEmails() {
     Stream.of("Personnel","Professionel").forEach(v->
     {
         BaseType type= new TypeEmail();
         type.setNom(v);
         baseTypeRepository.save(type);
     });
    }

    @Override
    public void initTypeDocuments() {
        Stream.of("Personnel","Entreprise").forEach(d->
        {
            BaseType doc= new TypeDocument();
            doc.setNom(d);
            baseTypeRepository.save(doc);
        });
    }
}
