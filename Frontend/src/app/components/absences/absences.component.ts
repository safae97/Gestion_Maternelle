
import { Component, OnInit } from '@angular/core';
import { AbsenceService  } from '../../services/absence.service';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {CommonModule, DatePipe} from '@angular/common';
import {Absence, EtudiantService} from '../../services/etudiant.service';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-absences',
  standalone: true,
  templateUrl: './absences.component.html',
  styleUrls: ['./absences.component.css'],
  imports: [HttpClientModule, FormsModule, DatePipe, CommonModule,RouterLink]
})
export class AbsencesComponent implements OnInit {
  absences: Absence[] = [];
  newAbsence: Absence = { id: 0, etudiantId: 0, enseignantId: 0, dateAbsence: '', motif: '' };


constructor(
  private absenceService: AbsenceService,
) {}

  ngOnInit(): void {
    this.getAllAbsences();
  }

  getAllAbsences(): void {
    this.absenceService.getAllAbsences().subscribe(
      (data) => {
        this.absences = data.map((absence) => ({
          ...absence,
          etudiantId: absence.etudiantId ?? 0,
          enseignantId: absence.enseignantId ?? 0,

        }));
      },
      (error) => {
        console.error('Error fetching absences:', error);
      }
    );
  }


  addAbsence(): void {
    if (
      this.newAbsence.etudiantId &&
      this.newAbsence.enseignantId &&
      this.newAbsence.dateAbsence &&
      this.newAbsence.motif
    ) {
      const absenceToSend = {
        dateAbsence: this.newAbsence.dateAbsence,
        motif: this.newAbsence.motif,
      };

      this.absenceService
        .addAbsence(absenceToSend, this.newAbsence.etudiantId, this.newAbsence.enseignantId)
        .subscribe(
          (response) => {
            console.log('Absence added successfully:', response);

            const transformedResponse: Absence = {
              ...response,
              etudiantId: response.etudiantId ?? 0, // Default to 0 if null
              enseignantId: response.enseignantId ?? 0, // Default to 0 if null
            };

            this.absences.push(transformedResponse);
          },
          (error) => {
            console.error('Error adding absence:', error);
          }
        );
    } else {
      console.error('All fields must be filled.');
    }
  }





  deleteAbsence(id: number | undefined): void {
    if (id !== undefined && confirm('Êtes-vous sûr de vouloir supprimer cet absence ?')) {
      this.absenceService.deleteAbsence(id).subscribe(
        () => {
          this.getAllAbsences(); // Reload the list of absences after successful deletion
        },
        (error) => {
          console.error('Erreur lors de la suppression de l\'absence', error);
        }
      );
    } else {
      console.error('ID de l\'absence est indéfini');
    }
  }

}

