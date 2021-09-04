package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Diplome;
import ma.ensa.infosat.gestion_entreprise.repository.DiplomeRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomeServiceImpl implements DiplomeService {
    @Autowired
    private DiplomeRepositiry diplomeRepositiry;

    @Override
    public List<Diplome> list() {
        return diplomeRepositiry.findAll();
    }

    @Override
    public Diplome save(Diplome d) {
        return diplomeRepositiry.save(d);
    }

    @Override
    public Diplome update(Long id, Diplome d) {
        d.setId(id);
        return diplomeRepositiry.save(d);
    }

    @Override
    public void delete(Long id) {
        diplomeRepositiry.deleteById(id);
    }

    @Override
    public List<Diplome> search(String cin,String description) {
        return diplomeRepositiry.search(cin,description);
    }
}
