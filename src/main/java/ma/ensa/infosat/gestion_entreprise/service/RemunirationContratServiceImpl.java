package ma.ensa.infosat.gestion_entreprise.service;

import lombok.AllArgsConstructor;
import ma.ensa.infosat.gestion_entreprise.entity.RemunirationContrat;
import ma.ensa.infosat.gestion_entreprise.repository.RemunirationContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemunirationContratServiceImpl implements RemunirationContratService {
    @Autowired
    private RemunirationContratRepository remunirationContratRepository;
    @Override
    public RemunirationContrat getRemunirationContrat(Long id) {
        return remunirationContratRepository.getById(id);
    }

    @Override
    public RemunirationContrat save(RemunirationContrat r) {
        return remunirationContratRepository.save(r);
    }

    @Override
    public RemunirationContrat update(Long id, RemunirationContrat r) {
         r.setId(id);
        return remunirationContratRepository.save(r);
    }

    @Override
    public void delete(Long id) {
        remunirationContratRepository.deleteById(id);
    }
}
