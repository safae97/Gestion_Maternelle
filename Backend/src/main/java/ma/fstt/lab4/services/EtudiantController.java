package ma.fstt.lab4.services;


import ma.fstt.lab4.entities.Enseignant;
import ma.fstt.lab4.entities.Etudiant;
import ma.fstt.lab4.metier.EnseignantMetier;
import ma.fstt.lab4.metier.EtudiantMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantMetier etudiantMetier;
    @Autowired
    private EnseignantMetier enseignantMetier;

    @PostMapping
    public ResponseEntity<Etudiant> ajouterEtudiant(@RequestBody Etudiant etudiant, @RequestParam Long enseignantId) {
        Enseignant enseignant = enseignantMetier.getEnseignantById(enseignantId);

        if (enseignant == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        etudiant.setEnseignant(enseignant);

        Etudiant savedEtudiant = etudiantMetier.ajouterEtudiant(etudiant);

        return ResponseEntity.ok(savedEtudiant);
    }



    @GetMapping
    public List<Etudiant> getTousLesEtudiants() {
        return etudiantMetier.getTousLesEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantParId(@PathVariable Long id) {
        return etudiantMetier.getEtudiantParId(id);
    }

    @PutMapping
    public Etudiant mettreAJourEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantMetier.mettreAJourEtudiant(etudiant);
    }

    @DeleteMapping("/{id}")
    public void supprimerEtudiantParId(@PathVariable Long id) {
        etudiantMetier.supprimerEtudiantParId(id);
    }

    @GetMapping("/nom/{nom}")
    public List<Etudiant> findByNom(@PathVariable String nom) {
        return etudiantMetier.findByNom(nom);
    }
}
