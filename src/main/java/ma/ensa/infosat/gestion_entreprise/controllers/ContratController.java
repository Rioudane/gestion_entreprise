package ma.ensa.infosat.gestion_entreprise.controllers;

import ma.ensa.infosat.gestion_entreprise.entity.Contact;
import ma.ensa.infosat.gestion_entreprise.entity.Contrat;
import ma.ensa.infosat.gestion_entreprise.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contrats")
public class ContratController {
    @Autowired
    private ContratService contratService;


    @GetMapping(path = "/list")
    public List<Contrat> list() {
        return contratService.listContrats() ;
    }

    @PostMapping(path = "/add")
    public Contrat add(@RequestBody Contrat c) {
        return contratService.save(c);
    }

    @PutMapping(value = "/update/{id}")
    public Contrat update(@PathVariable(name = "id") Long id,@RequestBody Contrat c) {
        return contratService.update(id,c);
    }

    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable(name = "id")Long id) {
        contratService.delete(id);

    }

    @GetMapping(value = "/search")
    public Contrat search(@RequestParam(name="cin",defaultValue = "") String cin) {
        return contratService.search(cin);
    }
}
