package ma.fstt.lab4.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Absence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "etudiant_id", nullable = false)
    @JsonIgnore // Prevent recursive serialization
    private Etudiant etudiant;

    @ManyToOne

    @JoinColumn(name = "enseignant_id", nullable = false)
    @JsonIgnore // Prevent recursive serialization

    private Enseignant enseignant;

    @Column(nullable = false)
    private String dateAbsence;

    @Column(nullable = false)
    private String motif;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public String getDateAbsence() {
        return dateAbsence;
    }

    public void setDateAbsence(String dateAbsence) {
        this.dateAbsence = dateAbsence;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @JsonProperty("etudiantId")
    public Long getEtudiantId() {
        return etudiant != null ? etudiant.getId() : null;
    }

    @JsonProperty("enseignantId")
    public Long getEnseignantId() {
        return enseignant != null ? enseignant.getId() : null;
    }
}