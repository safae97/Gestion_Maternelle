package ma.fstt.lab4.repository;

import ma.fstt.lab4.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

    Enseignant findByUsername(String username);
}
