package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Telephone;
import ma.ensa.infosat.gestion_entreprise.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelephoneServiceImpl implements TelephoneService {
    @Autowired
    private TelephoneRepository telephoneRepository;
    @Override
    public List<Telephone> listTelephones() {
        return telephoneRepository.findAll();
    }

    @Override
    public Telephone save(Telephone t) {
        return telephoneRepository.save(t);
    }

    @Override
    public Telephone update(Long id, Telephone t) {
        t.setId(id);
        return telephoneRepository.save(t);
    }

    @Override
    public void delete(Long id) {
        telephoneRepository.deleteById(id);
    }
}
