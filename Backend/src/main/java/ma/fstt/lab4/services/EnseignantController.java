package ma.fstt.lab4.services;

import ma.fstt.lab4.entities.Enseignant;
import ma.fstt.lab4.metier.EnseignantMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {

    @Autowired
    private EnseignantMetier enseignantMetier;

//    // Register an enseignant
//    @PostMapping("/register")
//    public Enseignant registerEnseignant(@RequestBody Enseignant enseignant) {
//        return enseignantMetier.registerEnseignant(enseignant);
//    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEnseignant(@RequestParam String username, @RequestParam String password) {
        Enseignant enseignant = enseignantMetier.loginEnseignant(username, password);

        if (enseignant == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .header("Content-Type", "application/json")
                    .body(Collections.singletonMap("error", "Invalid username or password"));
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(enseignant);
    }


//    @GetMapping("/current")
//    public ResponseEntity<Enseignant> getCurrentEnseignant(@RequestParam String username) {
//        Enseignant enseignant = enseignantMetier.findByUsername(username);
//
//        if (enseignant == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if not found
//        }
//
//        return ResponseEntity.ok(enseignant); // Return the current enseignant
//    }



}
