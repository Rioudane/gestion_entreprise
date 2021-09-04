package ma.ensa.infosat.gestion_entreprise.service;

import lombok.AllArgsConstructor;
import ma.ensa.infosat.gestion_entreprise.entity.*;
import ma.ensa.infosat.gestion_entreprise.repository.ContactRepository;
import ma.ensa.infosat.gestion_entreprise.repository.EmailRepository;
import ma.ensa.infosat.gestion_entreprise.service.registrastion.token.ConfirmationToken;
import ma.ensa.infosat.gestion_entreprise.service.registrastion.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static ma.ensa.infosat.gestion_entreprise.entity.AppUserRole.COLLABORATEUR;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService, UserDetailsService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final static String USER_NOT_FOUND_MSG="user with email %s Not found";
    private final ConfirmationTokenService confirmationTokenService;
    @Autowired
    private  ContactRepository contactRepository;
    @Override
    public List<Contact> listContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact save(Contact c) {

        if(c.getReseauSocials()!=null){
            List<ReseauSocial> reseauSocials=c.getReseauSocials();
            for(ReseauSocial reseauSocial :reseauSocials){ reseauSocial.setContact(c);}}
        if(c.getTelephones()!=null){
            List<Telephone> telephones=c.getTelephones();
            for(Telephone telephone :telephones){ telephone.setContact(c);}}
        if(c.getEmails()!=null){
            List<Email> emails=c.getEmails();
            for(Email email :emails){ email.setContact(c);}}
        if(c.getDocuments()!=null){
            List<Document> documents=c.getDocuments();
            for(Document document:documents){ document.setContact(c);}}
        if(c.getEmails()!=null){
            List<Email> emails=c.getEmails();
            for(Email email :emails){ email.setContact(c);}}
        if(c.getAddresses()!=null){
            List<Addresse> addresses=c.getAddresses();
            for(Addresse addresse :addresses){ addresse.setContact(c);}}
        if(c.getLangueContacts()!=null){
            List<LangueContact> langueContacts=c.getLangueContacts();
            for(LangueContact langueContact :langueContacts){ langueContact.setContact(c);}}
        if(c.getDiplomes()!=null){
            List<Diplome> diplomes=c.getDiplomes();
            for(Diplome diplome :diplomes){ diplome.setContact(c);}}
        return contactRepository.save(c);

    }

    @Override
    public Collaborateur saveCollab(Collaborateur c) {
        if(c.getReseauSocials()!=null){
            List<ReseauSocial> reseauSocials=c.getReseauSocials();
            for(ReseauSocial reseauSocial :reseauSocials){ reseauSocial.setContact(c);}}
        if(c.getTelephones()!=null){
            List<Telephone> telephones=c.getTelephones();
            for(Telephone telephone :telephones){ telephone.setContact(c);}}
        if(c.getEmails()!=null){
            List<Email> emails=c.getEmails();
            for(Email email :emails){ email.setContact(c);}}
        if(c.getDocuments()!=null){
            List<Document> documents=c.getDocuments();
            for(Document document:documents){ document.setContact(c);}}
        if(c.getEmails()!=null){
            List<Email> emails=c.getEmails();
            for(Email email :emails){ email.setContact(c);}}
        if(c.getAddresses()!=null){
            List<Addresse> addresses=c.getAddresses();
            for(Addresse addresse :addresses){ addresse.setContact(c);}}
        if(c.getLangueContacts()!=null){
            List<LangueContact> langueContacts=c.getLangueContacts();
            for(LangueContact langueContact :langueContacts){ langueContact.setContact(c);}}
        if(c.getDiplomes()!=null){
            List<Diplome> diplomes=c.getDiplomes();
            for(Diplome diplome :diplomes){ diplome.setContact(c);}}
        if(c.getCoordonneesBanquaires()!=null){
            List<CoordonneesBanquaire> coordonneesBanquaires=c.getCoordonneesBanquaires();
            for(CoordonneesBanquaire  coordonneeBanquaire:coordonneesBanquaires){ coordonneeBanquaire.setCollaborateur(c);}}
        if(c.getInformationsOrganismes()!=null){
            List<InformationsOrganisme> informationsOrganismes=c.getInformationsOrganismes();
            for(InformationsOrganisme informationsOrganisme :informationsOrganismes){ informationsOrganisme.setCollaborateur(c);}}
        if(c.getContrats()!=null){
            List<Contrat> contrats=c.getContrats();
            for(Contrat contrat :contrats){ contrat.setCollaborateur(c);}}
        return contactRepository.save(c);
    }


    @Override
    public Contact update(Long id, Contact c) {
        c.setId(id);
        return contactRepository.save(c);
    }

    @Override
    public void delete(Long id) {
     contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> search(String nom, String prenom) {
        return contactRepository.search(nom, prenom);
    }




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return  contactRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }

    public  String signUpUser(Contact c ){
        boolean userExists=contactRepository.findByEmail(c.getEmail())
                .isPresent();
        if(userExists){ throw new IllegalStateException("Email already TAKEN");}
        String encodedPassword=bCryptPasswordEncoder.encode(c.getPassword());
        c.setPassword(encodedPassword);
//        Set Mappings
        if(c.getReseauSocials()!=null){
            List<ReseauSocial> reseauSocials=c.getReseauSocials();
            for(ReseauSocial reseauSocial :reseauSocials){ reseauSocial.setContact(c);}}
        if(c.getTelephones()!=null){
            List<Telephone> telephones=c.getTelephones();
            for(Telephone telephone :telephones){ telephone.setContact(c);}}
        Email e=new Email();
        e.setAddresseEmail(c.getEmail());
        c.getEmails().add(e);
        if(c.getEmails()!=null){
            List<Email> emails=c.getEmails();
            for(Email email :emails){ email.setContact(c);};
          }
        if(c.getDocuments()!=null){
            List<Document> documents=c.getDocuments();
            for(Document document:documents){ document.setContact(c);}}
        if(c.getEmails()!=null){
            List<Email> emails=c.getEmails();
            for(Email email :emails){ email.setContact(c);}}
        if(c.getAddresses()!=null){
            List<Addresse> addresses=c.getAddresses();
            for(Addresse addresse :addresses){ addresse.setContact(c);}}
        if(c.getLangueContacts()!=null){
            List<LangueContact> langueContacts=c.getLangueContacts();
            for(LangueContact langueContact :langueContacts){ langueContact.setContact(c);}}
        if(c.getDiplomes()!=null){
            List<Diplome> diplomes=c.getDiplomes();
            for(Diplome diplome :diplomes){ diplome.setContact(c);}}

        contactRepository.save(c);
        // TODO:SEND CONFIRMATION TOKEN
        String token= UUID.randomUUID().toString();
        ConfirmationToken confirmationToken=new ConfirmationToken(token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),c);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        // TODO:SEND EMAIL

        return token;

    }
    public int enableContact(String email) {
        return contactRepository.enableContact(email);
    }
}
