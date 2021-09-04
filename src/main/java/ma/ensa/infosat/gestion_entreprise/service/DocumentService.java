package ma.ensa.infosat.gestion_entreprise.service;

import ma.ensa.infosat.gestion_entreprise.entity.Diplome;
import ma.ensa.infosat.gestion_entreprise.entity.Document;

import java.util.List;

public interface DocumentService {
    public List<Document> listDocument();
    public Document save(Document d);
    public Document update(Long id, Document d);
    public void delete(Long id);
    public List<Document> searchFichier(String  cin);
    public List<Document> searchDescription(String  cin);
}
