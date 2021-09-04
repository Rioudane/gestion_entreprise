package ma.ensa.infosat.gestion_entreprise.controllers;

import ma.ensa.infosat.gestion_entreprise.entity.Addresse;
import ma.ensa.infosat.gestion_entreprise.service.AddresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddresseController {
    @Autowired
    private AddresseService addresseService;
    @GetMapping(path = "/list")
    public List<Addresse> get(){return addresseService.listAddresses();}


    @PostMapping(path = "/add")
    public Addresse add(@RequestBody Addresse addresse) {
       
        return  addresseService.save(addresse);
    }
    @PutMapping(value = "/update/{id}")
    public Addresse update(@PathVariable(name = "id") Long id,@RequestBody Addresse addresse) {
        return addresseService.update(id, addresse);
    }

    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable(name = "id")Long id) {
        addresseService.delete(id);
    }


}
