package ma.ensa.infosat.gestion_entreprise.controllers;

import ma.ensa.infosat.gestion_entreprise.entity.Diplome;
import ma.ensa.infosat.gestion_entreprise.service.DiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiplomeController {

    @Autowired
    private DiplomeService diplomeService;

    @GetMapping(path = "/list")
    public List<Diplome> list() {
        return diplomeService.list();
    }

    @PostMapping(path = "/add")
    public Diplome add(@RequestBody Diplome diplome) {
        return diplomeService.save(diplome);
    }

    @PutMapping(value = "/update/{id}")
    public Diplome update(@PathVariable(name = "id") Long id,@RequestBody Diplome diplome) {
        return diplomeService.update(id,diplome) ;
    }

    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable(name = "id")Long id) {
        diplomeService.delete(id);
    }

    @GetMapping(value = "/search")
    public List<Diplome> search(@RequestParam(name="cin",defaultValue = "") String cin,@RequestParam(name="description",defaultValue = "") String descriprtion) {
        return diplomeService.search(cin,descriprtion);
    }
}
