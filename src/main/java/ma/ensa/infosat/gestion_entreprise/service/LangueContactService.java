package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.LangueContact;

import java.util.List;

public interface LangueContactService {
    public List<LangueContact> listLangues();
    public LangueContact save(LangueContact l);
    public LangueContact update(Long id,LangueContact c);
    public void delete(Long id);
}
