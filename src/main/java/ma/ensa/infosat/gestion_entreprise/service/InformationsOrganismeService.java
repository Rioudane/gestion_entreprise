package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.InformationsOrganisme;

import java.util.List;

public interface InformationsOrganismeService {
    public List<InformationsOrganisme> listInformationsOrganismes();
    public InformationsOrganisme save(InformationsOrganisme i);
    public InformationsOrganisme update(Long id,InformationsOrganisme i);
    public void delete(Long id);
}
