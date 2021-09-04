package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Telephone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TelephoneService {
    public List<Telephone> listTelephones();
    public Telephone save(Telephone t);
    public Telephone update(Long id,Telephone t);
    public void delete(Long id);
}
