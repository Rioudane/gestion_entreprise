package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.ReseauSocial;

import java.util.List;

public interface ReseauSocialService {
    public List<ReseauSocial> listReseauSocials();
    public ReseauSocial save(ReseauSocial r);
    public ReseauSocial update(Long id,ReseauSocial r);
    public void delete(Long id);
}
