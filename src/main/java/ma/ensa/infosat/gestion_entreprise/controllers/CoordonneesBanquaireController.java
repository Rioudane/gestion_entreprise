package ma.ensa.infosat.gestion_entreprise.controllers;

import ma.ensa.infosat.gestion_entreprise.entity.Contact;
import ma.ensa.infosat.gestion_entreprise.entity.CoordonneesBanquaire;
import ma.ensa.infosat.gestion_entreprise.service.CoordonneesBanquaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CompteBanquaires")
public class CoordonneesBanquaireController {
@Autowired
private CoordonneesBanquaireService coordonneesBanquaireService;

    @GetMapping(path = "/list")
    public List<CoordonneesBanquaire> list() {
        return coordonneesBanquaireService.list();
    }

    @PostMapping(path = "/add")
    public CoordonneesBanquaire add(@RequestBody CoordonneesBanquaire c) {
        return coordonneesBanquaireService.save(c);
    }

    @PutMapping(value = "/update/{id}")
    public CoordonneesBanquaire update(@PathVariable(name = "id") Long id,@RequestBody CoordonneesBanquaire c) {
        return coordonneesBanquaireService.update(id,c) ;
    }

    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable(name = "id")Long id) { coordonneesBanquaireService.delete(id);

    }

    @GetMapping(value = "/search")
    public CoordonneesBanquaire search(@RequestParam(name="cin",defaultValue = "") String cin) {
        return coordonneesBanquaireService.search(cin);
    }
}
