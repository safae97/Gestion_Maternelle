package ma.fstt.lab4.metier;

import ma.fstt.lab4.entities.Enseignant;
import ma.fstt.lab4.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnseignantMetier {

    @Autowired
    private EnseignantRepository enseignantRepository;

    public Enseignant register(Enseignant teacher) {
        return enseignantRepository.save(teacher);
    }

    public Enseignant loginEnseignant(String username, String password) {
        Enseignant enseignant = enseignantRepository.findByUsername(username);

        if (enseignant != null && enseignant.getPassword() != null && enseignant.getPassword().equals(password)) {
            return enseignant;
        }

        return null;
    }


    public Enseignant findByUsername(String username) {
        return enseignantRepository.findByUsername(username);
    }
    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id).orElse(null); // Fetch enseignant by ID
    }
}
