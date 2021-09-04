package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.InformationsOrganisme;
import ma.ensa.infosat.gestion_entreprise.repository.InformationsOrganismeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationsOrganismeServiceImpl implements InformationsOrganismeService{
    @Autowired
    private InformationsOrganismeRepository informationsOrganismeRepository;
    @Override
    public List<InformationsOrganisme> listInformationsOrganismes() {
        return informationsOrganismeRepository.findAll();
    }

    @Override
    public InformationsOrganisme save(InformationsOrganisme i) {
        return informationsOrganismeRepository.save(i);
    }

    @Override
    public InformationsOrganisme update(Long id, InformationsOrganisme i) {
        i.setId(id);
        return informationsOrganismeRepository.save(i);
    }

    @Override
    public void delete(Long id) {
        informationsOrganismeRepository.deleteById(id);
    }
}
