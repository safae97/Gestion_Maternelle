import { Component } from '@angular/core';
import {Etudiant, EtudiantService} from '../../services/etudiant.service'; // Import the service
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {Router, RouterLink} from '@angular/router';
@Component({
  selector: 'app-ajouter-etudiant',
  standalone: true,
  templateUrl: './ajouter-etudiant.component.html',
  styleUrls: ['./ajouter-etudiant.component.css'],
  imports: [CommonModule, FormsModule, RouterLink] // Specify imports if needed
})
export class AjouterEtudiantComponent {
  etudiants: Etudiant[] = [];

  newEtudiant: Partial<Etudiant> = {
    nom: '',
    prenom: '',
    dateNaissance: new Date(),
    absences: [],
    enseignantId: undefined, // Store enseignantId directly
  };
  constructor(
    private etudiantService: EtudiantService,
    private router: Router // Inject Router
  ) {}
  addEtudiant(): void {
    if (this.newEtudiant.nom && this.newEtudiant.prenom && this.newEtudiant.dateNaissance && this.newEtudiant.enseignantId) {
      const etudiantToSend: Etudiant = {
        nom: this.newEtudiant.nom!,
        prenom: this.newEtudiant.prenom!,
        dateNaissance: this.newEtudiant.dateNaissance!,
        enseignantId: this.newEtudiant.enseignantId!,
        absences: [],
      };

      this.etudiantService.addEtudiant(etudiantToSend, this.newEtudiant.enseignantId).subscribe(
        (etudiant) => {
          this.etudiants.push(etudiant);
          this.router.navigate(['/etudiants']);

        },
        (error) => {
          console.error('Erreur lors de l\'ajout de l\'étudiant', error);
        }
      );
    } else {
      console.error("All fields must be filled.");
    }
  }
}
