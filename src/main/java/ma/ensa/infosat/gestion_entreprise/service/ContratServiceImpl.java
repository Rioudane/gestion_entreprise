package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Contact;
import ma.ensa.infosat.gestion_entreprise.entity.Contrat;
import ma.ensa.infosat.gestion_entreprise.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratServiceImpl implements ContratService{
    @Autowired

    private ContratRepository contratRepository;
    @Override
    public Contrat getContrat(Long id) {
        return contratRepository.getById(id) ;
    }

    @Override
    public Contrat save(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat update(Long id, Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public void delete(Long id) {
     contratRepository.deleteById(id);
    }

    @Override
    public List<Contrat> listContrats() {
        return contratRepository.findAll();
    }
    @Override
    public Contrat search(String cin) {
        return contratRepository.search(cin);
    }
}
