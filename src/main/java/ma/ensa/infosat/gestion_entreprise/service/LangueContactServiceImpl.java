package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.LangueContact;
import ma.ensa.infosat.gestion_entreprise.repository.LangueContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangueContactServiceImpl implements LangueContactService {
    @Autowired
    private LangueContactRepository langueContactRepository;
    @Override
    public List<LangueContact> listLangues() {
        return langueContactRepository.findAll();
    }

    @Override
    public LangueContact save(LangueContact l) {
        return langueContactRepository.save(l);
    }

    @Override
    public LangueContact update(Long id, LangueContact c) {
        c.setId(id);
        return langueContactRepository.save(c);
    }

    @Override
    public void delete(Long id) {
        langueContactRepository.deleteById(id);
    }
}
