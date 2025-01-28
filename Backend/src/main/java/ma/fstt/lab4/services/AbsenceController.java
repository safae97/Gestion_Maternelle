package ma.fstt.lab4.services;

import ma.fstt.lab4.entities.Absence;
import ma.fstt.lab4.entities.Enseignant;
import ma.fstt.lab4.entities.Etudiant;
import ma.fstt.lab4.metier.AbsenceMetier;
import ma.fstt.lab4.metier.EnseignantMetier;
import ma.fstt.lab4.metier.EtudiantMetier;
import ma.fstt.lab4.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    private AbsenceMetier absenceMetier;
    @Autowired
    private EtudiantMetier etudiantMetier;
    @Autowired
    private EnseignantMetier enseignantMetier;

    @PostMapping
    public ResponseEntity<Absence> ajouterAbsence(
            @RequestBody Absence absence,
            @RequestParam Long etudiantId,
            @RequestParam Long enseignantId) {

        Etudiant etudiant = etudiantMetier.getEtudiantParId(etudiantId);
        if (etudiant == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
        absence.setEtudiant(etudiant);

        Enseignant enseignant = enseignantMetier.getEnseignantById(enseignantId);
        if (enseignant == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
        absence.setEnseignant(enseignant);

        Absence savedAbsence = absenceMetier.ajouterAbsence(absence);
        return ResponseEntity.ok(savedAbsence);
    }


    @GetMapping
    public ResponseEntity<List<Absence>> getToutesLesAbsences() {
        List<Absence> absences = absenceMetier.getToutesLesAbsences();
        return new ResponseEntity<>(absences, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Absence> getAbsenceParId(@PathVariable Long id) {
        Optional<Absence> absence = absenceMetier.getAbsenceParId(id);
        return absence.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Absence> mettreAJourAbsence(@PathVariable Long id, @RequestBody Absence absence) {
        Optional<Absence> absenceExistante = absenceMetier.getAbsenceParId(id);
        if (absenceExistante.isPresent()) {
            absence.setId(id);
            Absence updatedAbsence = absenceMetier.mettreAJourAbsence(absence);
            return new ResponseEntity<>(updatedAbsence, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAbsenceParId(@PathVariable Long id) {
        Optional<Absence> absence = absenceMetier.getAbsenceParId(id);
        if (absence.isPresent()) {
            absenceMetier.supprimerAbsenceParId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/etudiant/{etudiantId}")
    public ResponseEntity<List<Absence>> findByEtudiant(@PathVariable Long etudiantId) {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(etudiantId);
        List<Absence> absences = absenceMetier.findByEtudiant(etudiant);
        return new ResponseEntity<>(absences, HttpStatus.OK);
    }

    @GetMapping("/date/{dateAbsence}")
    public ResponseEntity<List<Absence>> findByDateAbsence(@PathVariable String dateAbsence) {
        List<Absence> absences = absenceMetier.findByDateAbsence(dateAbsence);
        return new ResponseEntity<>(absences, HttpStatus.OK);
    }

    @GetMapping("/etudiant/{etudiantId}/date/{dateAbsence}")
    public ResponseEntity<List<Absence>> findByEtudiantAndDateAbsence(@PathVariable Long etudiantId,
                                                                      @PathVariable String dateAbsence) {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(etudiantId);
        List<Absence> absences = absenceMetier.findByEtudiantAndDateAbsence(etudiant, dateAbsence);
        return new ResponseEntity<>(absences, HttpStatus.OK);
    }
}