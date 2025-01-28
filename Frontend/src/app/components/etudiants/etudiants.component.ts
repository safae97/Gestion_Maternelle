import { Component, OnInit } from '@angular/core';
import { EtudiantService, Etudiant } from '../../services/etudiant.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-etudiants',
  templateUrl: './etudiants.component.html',
  standalone: true,
  styleUrls: ['./etudiants.component.css'],
  imports: [CommonModule, FormsModule, RouterLink],
})
export class EtudiantsComponent implements OnInit {
  etudiants: Etudiant[] = [];
  selectedEtudiant: Etudiant | null = null;

  newEtudiant: Partial<Etudiant> = {
    nom: '',
    prenom: '',
    dateNaissance: new Date(),
    absences: [],
    enseignantId: undefined,
  };

  constructor(
    private etudiantService: EtudiantService
  ) {}

  ngOnInit(): void {
    this.loadEtudiants();
  }

  loadEtudiants(): void {
    this.etudiantService.getEtudiants().subscribe((data) => {
      this.etudiants = data;
    });
  }

  addEtudiant(): void {
    if (this.newEtudiant.nom && this.newEtudiant.prenom && this.newEtudiant.dateNaissance && this.newEtudiant.enseignantId) {
      const etudiantToSend: Etudiant = {
        nom: this.newEtudiant.nom!,
        prenom: this.newEtudiant.prenom!,
        dateNaissance: this.newEtudiant.dateNaissance!,
        enseignantId: this.newEtudiant.enseignantId!,
        absences: [],
      };

      // Sending the validated Etudiant object to the service
      this.etudiantService.addEtudiant(etudiantToSend, this.newEtudiant.enseignantId).subscribe(
        (etudiant) => {
          this.etudiants.push(etudiant);
        },
        (error) => {
          console.error('Erreur lors de l\'ajout de l\'étudiant', error);
        }
      );
    } else {
      console.error("All fields must be filled.");
    }
  }



  selectEtudiant(etudiant: Etudiant): void {
    this.selectedEtudiant = { ...etudiant };  // Crée une copie de l'étudiant pour l'éditer
  }

  deleteEtudiant(id: number | undefined): void {
    if (id !== undefined && confirm('Êtes-vous sûr de vouloir supprimer cet étudiant ?')) {
      this.etudiantService.deleteEtudiant(id).subscribe(
        () => {
          this.loadEtudiants();
        },
        (error) => {
          console.error('Erreur lors de la suppression de l\'étudiant', error);
        }
      );
    } else {
      console.error('ID de l\'étudiant est indéfini');
    }
  }

  updateEtudiant(): void {
    if (this.selectedEtudiant) {
      this.etudiantService.updateEtudiant(this.selectedEtudiant).subscribe(updatedEtudiant => {
        const index = this.etudiants.findIndex(etudiant => etudiant.id === updatedEtudiant.id);
        if (index !== -1) {
          this.etudiants[index] = updatedEtudiant;
        }
        this.selectedEtudiant = null;
      });
    }
  }
}
