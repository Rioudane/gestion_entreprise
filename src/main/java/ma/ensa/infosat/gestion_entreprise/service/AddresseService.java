package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Addresse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddresseService {

    public Addresse save(Addresse addresse);
    public List<Addresse> listAddresses();
    public Addresse update(Long id,Addresse addresse);
    public void delete(Long id);
}
