package ma.ensa.infosat.gestion_entreprise.controllers;

import ma.ensa.infosat.gestion_entreprise.entity.Contact;
import ma.ensa.infosat.gestion_entreprise.entity.Email;
import ma.ensa.infosat.gestion_entreprise.service.ContactService;
import ma.ensa.infosat.gestion_entreprise.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private ContactService contactService;
    @GetMapping(path = "/list")
    public List<Email>  getEmails(){return emailService.listEmails();}


    @PostMapping(path = "/add")
    public Email addEmail(@RequestBody Email e) {
        Contact contact=e.getContact();
        contactService.save(contact);
        return  emailService.save(e);
    }


    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable(name = "id")Long id) {

        emailService.delete(id);
    }
}
