package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Email;

import java.util.List;

public interface EmailService {
    public List<Email> listEmails();
    public Email save(Email e);
    public Email update(Long id,Email e);
    public void delete(Long id);
}
