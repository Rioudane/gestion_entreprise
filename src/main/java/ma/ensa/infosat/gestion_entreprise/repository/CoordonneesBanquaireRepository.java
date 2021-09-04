package ma.ensa.infosat.gestion_entreprise.repository;

import ma.ensa.infosat.gestion_entreprise.entity.CoordonneesBanquaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface CoordonneesBanquaireRepository extends JpaRepository<CoordonneesBanquaire,Long> {
    @Query("SELECT c from CoordonneesBanquaire c where c.collaborateur.cin like :x ")
    public CoordonneesBanquaire search(@Param("x")String cin );
}
