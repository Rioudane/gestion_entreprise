package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Contact;
import ma.ensa.infosat.gestion_entreprise.entity.Email;
import ma.ensa.infosat.gestion_entreprise.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private EmailRepository emailRepository;
    @Override
    public List<Email> listEmails() {
        return emailRepository.findAll();
    }

    @Override
    public Email save(Email e) {

        return emailRepository.save(e);
    }

    @Override
    public Email update(Long id, Email e) {
        e.setId(id);
        return emailRepository.save(e);
    }

    @Override
    public void delete(Long id) {
        emailRepository.deleteById(id);

    }
}
