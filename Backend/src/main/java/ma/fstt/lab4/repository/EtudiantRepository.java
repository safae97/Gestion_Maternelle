package ma.fstt.lab4.repository;

import ma.fstt.lab4.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    default Etudiant ajouterEtudiant(Etudiant etudiant) {
        return save(etudiant);
    }
    default List<Etudiant> getTousLesEtudiants() {
        return findAll(); // Méthode "findAll" de JpaRepository
    }

    default Optional<Etudiant> getEtudiantParId(Long id) {
        return findById(id); // Méthode "findById" de JpaRepository
    }

    default Etudiant mettreAJourEtudiant(Etudiant etudiant) {
        return save(etudiant);
    }

    default void supprimerEtudiantParId(Long id) {
        deleteById(id); // Méthode "deleteById" de JpaRepository
    }

    List<Etudiant> findByNom(String nom);
}
