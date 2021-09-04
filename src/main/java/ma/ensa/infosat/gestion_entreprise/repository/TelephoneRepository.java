package ma.ensa.infosat.gestion_entreprise.repository;

import ma.ensa.infosat.gestion_entreprise.entity.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface TelephoneRepository extends JpaRepository<Telephone,Long> {
}
