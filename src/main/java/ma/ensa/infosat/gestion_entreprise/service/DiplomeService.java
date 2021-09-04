package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Diplome;

import java.util.List;

public interface DiplomeService {
    public List<Diplome> list();
    public Diplome save(Diplome d);
    public Diplome update(Long id, Diplome d);
    public void delete(Long id);
    public List<Diplome> search(String cin,String description);
}
