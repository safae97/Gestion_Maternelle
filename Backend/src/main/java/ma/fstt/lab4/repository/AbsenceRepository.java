package ma.fstt.lab4.repository;

import ma.fstt.lab4.entities.Absence;
import ma.fstt.lab4.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {

    List<Absence> findByEtudiant(Etudiant etudiant);
    List<Absence> findByDateAbsence(String dateAbsence);
    List<Absence> findByEtudiantAndDateAbsence(Etudiant etudiant, String dateAbsence);

    default List<Absence> getToutesLesAbsences() {
        return findAll();
    }
    default Absence ajouterAbsence(Absence absence) {
        return save(absence);
    }

    default Optional<Absence> getAbsenceParId(Long id) {
        return findById(id);
    }

    default Absence mettreAJourAbsence(Absence absence) {
        return save(absence);
    }

    default void supprimerAbsenceParId(Long id) {
        deleteById(id);
    }
}