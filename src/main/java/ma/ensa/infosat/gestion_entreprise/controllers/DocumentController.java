package ma.ensa.infosat.gestion_entreprise.controllers;

import ma.ensa.infosat.gestion_entreprise.entity.Contact;
import ma.ensa.infosat.gestion_entreprise.entity.Document;
import ma.ensa.infosat.gestion_entreprise.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping(path = "/list")
    public List<Document> list() {
        return documentService.listDocument();
    }

    @PostMapping(path = "/add")
    public Document add(@RequestBody Document d) {
        return documentService.save(d);
    }

    @PutMapping(value = "/update/{id}")
    public Document update(@PathVariable(name = "id") Long id,@RequestBody Document d) {
        return documentService.update(id, d);
    }

    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable(name = "id")Long id) {

        documentService.delete(id);
    }

    @GetMapping(value = "/search/fichier")
    public List<Document> searchFichier(@RequestParam(name="nom",defaultValue = "") String nom) {
        return documentService.searchFichier("%"+nom+"%");
    }
    @GetMapping(value = "/search/discription")
    public List<Document> searchDiscription(@RequestParam(name="nom",defaultValue = "") String nom) {
        return documentService.searchDescription("%"+nom+"%");
    }
}

