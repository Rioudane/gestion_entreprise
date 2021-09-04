package ma.ensa.infosat.gestion_entreprise;

import ma.ensa.infosat.gestion_entreprise.service.BaseTypeInitService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionEntrepriseApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GestionEntrepriseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
    entrepriseInitService.initVilles();
    entrepriseInitService.initTypesEmails();
    entrepriseInitService.initTypeDocuments();
    entrepriseInitService.initTypeReseauSocials();*/

    }
}
