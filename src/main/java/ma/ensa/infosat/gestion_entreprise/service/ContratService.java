package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Contact;
import ma.ensa.infosat.gestion_entreprise.entity.Contrat;
import ma.ensa.infosat.gestion_entreprise.entity.Email;

import java.util.List;


public interface ContratService {
    public Contrat getContrat(Long id);
    public Contrat save(Contrat c);
    public Contrat update(Long id,Contrat c);
    public void delete(Long id);
    public List<Contrat> listContrats();
    public Contrat search(String cin);
 }
