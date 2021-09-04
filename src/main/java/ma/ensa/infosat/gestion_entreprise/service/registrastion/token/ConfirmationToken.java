package ma.ensa.infosat.gestion_entreprise.service.registrastion.token;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensa.infosat.gestion_entreprise.entity.Contact;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private  String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private  LocalDateTime confirmedAt;

    @ManyToOne@JoinColumn(nullable = false,name = "contact_id")
    private Contact contact;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, Contact contact) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.contact = contact;
    }
}
