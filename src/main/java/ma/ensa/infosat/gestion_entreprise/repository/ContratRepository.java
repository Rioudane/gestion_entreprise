package ma.ensa.infosat.gestion_entreprise.repository;

import ma.ensa.infosat.gestion_entreprise.entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ContratRepository extends JpaRepository<Contrat,Long> {
    @Query("SELECT c from Contrat c where c.collaborateur.cin like :x ")
    public Contrat search(@Param("x")String cin );
}
