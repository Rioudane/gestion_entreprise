package ma.ensa.infosat.gestion_entreprise.repository;

import ma.ensa.infosat.gestion_entreprise.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional(readOnly = true)
@RepositoryRestResource(exported = false)
public interface ContactRepository extends JpaRepository<Contact,Long> {
   // @Query("SELECT e from Email e,Contact c where c.username like :email")
    Optional<Contact> findByEmail(String email);
    @Query("SELECT c from Contact c where (c.nom like :x and c.prenom like :y)or (c.prenom like :x and c.nom like :y)")
    List<Contact> search(@Param("x")String nom , @Param("y")String prenom);
    @Transactional
    @Modifying
    @Query("UPDATE Contact a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableContact(String email);
}
