package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.RemunirationContrat;

import java.util.List;

public interface RemunirationContratService {
    public RemunirationContrat getRemunirationContrat(Long id);
    public RemunirationContrat save(RemunirationContrat r);
    public RemunirationContrat update(Long id,RemunirationContrat r);
    public void delete(Long id);
}
