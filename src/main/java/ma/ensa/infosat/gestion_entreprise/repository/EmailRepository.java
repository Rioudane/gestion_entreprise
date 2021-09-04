package ma.ensa.infosat.gestion_entreprise.repository;

import ma.ensa.infosat.gestion_entreprise.entity.Document;
import ma.ensa.infosat.gestion_entreprise.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface EmailRepository extends JpaRepository<Email,Long> {
    @Query("SELECT e from Email e where  e.addresseEmail like :x ")
    public List<Document> searchEmail(@Param("x")String addresseEmail );
}
