package ma.ensa.infosat.gestion_entreprise.controllers;

import ma.ensa.infosat.gestion_entreprise.entity.Collaborateur;
import ma.ensa.infosat.gestion_entreprise.entity.Contact;
import ma.ensa.infosat.gestion_entreprise.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping(path = "/list")
    public List<Contact> list() {
        return contactService.listContacts();
    }

    @PostMapping(path = "/add")
    public Contact add(@RequestBody Contact c) {
        return contactService.save(c);
    }

    @PostMapping(path = "/signin")
    public Collaborateur sign(@RequestBody Collaborateur c) {
        return contactService.saveCollab(c);
    }

    @PutMapping(value = "/update/{id}")
    public Contact update(@PathVariable(name = "id") Long id,@RequestBody Contact c) {
        return contactService.update(id, c);
    }

    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable(name = "id")Long id) {
        contactService.delete(id);
    }

    @GetMapping(value = "/search")
    public List<Contact> search(@RequestParam(name="nom",defaultValue = "") String nom,@RequestParam(name="prenom",defaultValue = "") String prenom) {
        return contactService.search("%"+nom+"%","%"+prenom+"%");
    }

}
