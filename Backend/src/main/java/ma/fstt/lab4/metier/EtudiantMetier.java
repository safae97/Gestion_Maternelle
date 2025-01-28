package ma.fstt.lab4.metier;

import ma.fstt.lab4.entities.Enseignant;
import ma.fstt.lab4.entities.Etudiant;
import ma.fstt.lab4.repository.EnseignantRepository;
import ma.fstt.lab4.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantMetier {

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private EnseignantRepository enseignantRepository;

    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public List<Etudiant> getTousLesEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantParId(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }
    public Etudiant mettreAJourEtudiant(Etudiant etudiant) {
        if (etudiant.getId() != null && etudiantRepository.existsById(etudiant.getId())) {
            return etudiantRepository.save(etudiant);
        }
        throw new RuntimeException("L'étudiant avec l'ID " + etudiant.getId() + " n'existe pas.");
    }

    public void supprimerEtudiantParId(Long id) {
        if (etudiantRepository.existsById(id)) {
            etudiantRepository.deleteById(id);
        } else {
            throw new RuntimeException("L'étudiant avec l'ID " + id + " n'existe pas.");
        }
    }

    public Enseignant findById(Long id) {
        return enseignantRepository.findById(id).orElse(null);
    }

    public List<Etudiant> findByNom(String nom) {
        return etudiantRepository.findByNom(nom);
    }
}
