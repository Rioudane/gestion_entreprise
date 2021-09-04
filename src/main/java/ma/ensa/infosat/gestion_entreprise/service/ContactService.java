package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Collaborateur;
import ma.ensa.infosat.gestion_entreprise.entity.Contact;
import ma.ensa.infosat.gestion_entreprise.entity.Email;

import java.util.List;

public interface ContactService  {
    public List<Contact> listContacts();
    public Contact save(Contact c);
    public Collaborateur saveCollab(Collaborateur c);
    public Contact update(Long id,Contact c);
    public void delete(Long id);
    public List<Contact> search(String nom,String prenom);
}
