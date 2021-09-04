package ma.ensa.infosat.gestion_entreprise.repository;

import ma.ensa.infosat.gestion_entreprise.entity.Diplome;
import ma.ensa.infosat.gestion_entreprise.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface DocumentRepository extends JpaRepository<Document,Long> {
    @Query("SELECT d from Document d where d.fichier like :x ")
    public List<Document> searchFichier(@Param("x")String fichier );
    @Query("SELECT d from Document d where d.description like :x ")
    public List<Document> searchDescription(@Param("x")String description );
}
