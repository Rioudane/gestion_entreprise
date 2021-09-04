package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Addresse;
import ma.ensa.infosat.gestion_entreprise.repository.AddresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AddresseServiceImpl implements AddresseService {

    @Autowired
    private AddresseRepository addresseRepository;

    @Override
    public Addresse save(Addresse addresse) {

        return addresseRepository.save(addresse);
    }

    @Override
    public List<Addresse> listAddresses() {
        return addresseRepository.findAll();
    }

    @Override
    public Addresse update(Long id,Addresse addresse) {
        addresse.setId(id);
        return addresseRepository.save(addresse);
    }

    @Override
    public void delete(Long id) {
       addresseRepository.deleteById(id);
    }
}
