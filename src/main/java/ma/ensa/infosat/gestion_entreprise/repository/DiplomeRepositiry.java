package ma.ensa.infosat.gestion_entreprise.repository;

import ma.ensa.infosat.gestion_entreprise.entity.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface DiplomeRepositiry extends JpaRepository<Diplome,Long> {
    @Query("SELECT DISTINCT d from Diplome d ,Collaborateur c where c.cin like :x and d.intituleDiplome.description like :y ")
    public List<Diplome> search(@Param("x")String cin, @Param("y")String  description);
}
