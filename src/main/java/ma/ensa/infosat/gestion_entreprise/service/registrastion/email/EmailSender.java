package ma.ensa.infosat.gestion_entreprise.service.registrastion.email;

public interface EmailSender {
    void send(String to, String email);
}
