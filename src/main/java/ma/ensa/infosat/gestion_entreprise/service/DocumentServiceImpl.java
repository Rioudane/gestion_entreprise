package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Diplome;
import ma.ensa.infosat.gestion_entreprise.entity.Document;
import ma.ensa.infosat.gestion_entreprise.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl  implements  DocumentService{
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<Document> listDocument() {
        return documentRepository.findAll();
    }

    @Override
    public Document save(Document d) {
        return documentRepository.save(d);
    }

    @Override
    public Document update(Long id, Document d) {
        d.setId(id);
        return documentRepository.save(d);
    }

    @Override
    public void delete(Long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public List<Document> searchFichier(String nom) {
        return documentRepository.searchFichier(nom);
    }

    @Override
    public List<Document> searchDescription(String description) {
        return documentRepository.searchDescription(description);
    }


}
