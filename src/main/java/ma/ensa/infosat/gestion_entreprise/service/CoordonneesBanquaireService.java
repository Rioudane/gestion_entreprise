package ma.ensa.infosat.gestion_entreprise.service;


import ma.ensa.infosat.gestion_entreprise.entity.Contrat;
import ma.ensa.infosat.gestion_entreprise.entity.CoordonneesBanquaire;

import java.util.List;

public interface CoordonneesBanquaireService {
    public List<CoordonneesBanquaire> list();
    public CoordonneesBanquaire save(CoordonneesBanquaire c);
    public CoordonneesBanquaire update(Long id,CoordonneesBanquaire c);
    public void delete(Long id);
    public CoordonneesBanquaire search(String cin);
}
