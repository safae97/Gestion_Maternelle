package ma.fstt.lab4.metier;

import ma.fstt.lab4.entities.Absence;
import ma.fstt.lab4.entities.Enseignant;
import ma.fstt.lab4.entities.Etudiant;
import ma.fstt.lab4.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class AbsenceMetier {

    @Autowired
    private AbsenceRepository absenceRepository;

    public Absence ajouterAbsence(Absence absence) {
        if (absence.getEnseignant() == null || absence.getEtudiant() == null) {
            throw new IllegalArgumentException("Both Enseignant and Etudiant must be provided.");
        }
        return absenceRepository.save(absence);
    }

    public List<Absence> getToutesLesAbsences() {
        return absenceRepository.getToutesLesAbsences();
    }

    public Optional<Absence> getAbsenceParId(Long id) {
        return absenceRepository.findById(id);
    }

    public Absence mettreAJourAbsence(Absence absence) {
        if (!absenceRepository.existsById(absence.getId())) {
            throw new IllegalArgumentException("Absence not found.");
        }
        return absenceRepository.save(absence);
    }

    public void supprimerAbsenceParId(Long id) {
        if (!absenceRepository.existsById(id)) {
            throw new IllegalArgumentException("Absence not found.");
        }
        absenceRepository.deleteById(id);
    }

    public List<Absence> findByEtudiant(Etudiant etudiant) {
        return absenceRepository.findByEtudiant(etudiant);
    }

    public List<Absence> findByDateAbsence(String dateAbsence) {
        return absenceRepository.findByDateAbsence(dateAbsence);
    }

    public List<Absence> findByEtudiantAndDateAbsence(Etudiant etudiant, String dateAbsence) {
        return absenceRepository.findByEtudiantAndDateAbsence(etudiant, dateAbsence);
    }
}
