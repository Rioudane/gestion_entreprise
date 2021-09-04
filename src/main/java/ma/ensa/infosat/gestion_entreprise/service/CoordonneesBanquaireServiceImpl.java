package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.CoordonneesBanquaire;
import ma.ensa.infosat.gestion_entreprise.repository.CoordonneesBanquaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordonneesBanquaireServiceImpl implements CoordonneesBanquaireService {
    @Autowired
    private CoordonneesBanquaireRepository coordonneesBanquaireRepository;
    @Override
    public List<CoordonneesBanquaire> list() {
        return coordonneesBanquaireRepository.findAll();
    }

    @Override
    public CoordonneesBanquaire save(CoordonneesBanquaire c) {
        return coordonneesBanquaireRepository.save(c);
    }

    @Override
    public CoordonneesBanquaire update(Long id, CoordonneesBanquaire c) {
        c.setId(id);
        return coordonneesBanquaireRepository.save(c);
    }

    @Override
    public void delete(Long id) {
       coordonneesBanquaireRepository.deleteById(id);
    }

    @Override
    public CoordonneesBanquaire search(String cin) {
        return coordonneesBanquaireRepository.search(cin);
    }
}
