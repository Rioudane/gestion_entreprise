package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.ReseauSocial;
import ma.ensa.infosat.gestion_entreprise.repository.ReseauSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseauSocialServiceImpl implements ReseauSocialService{
    @Autowired
    private ReseauSocialRepository reseauSocialRepository;
    @Override
    public List<ReseauSocial> listReseauSocials() {
        return reseauSocialRepository.findAll();
    }

    @Override
    public ReseauSocial save(ReseauSocial r) {
        return reseauSocialRepository.save(r);
    }

    @Override
    public ReseauSocial update(Long id, ReseauSocial r) {
        r.setId(id);
        return reseauSocialRepository.save(r);
    }

    @Override
    public void delete(Long id) {
        reseauSocialRepository.deleteById(id);
    }
}
