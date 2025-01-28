import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EtudiantsComponent } from './components/etudiants/etudiants.component';
import { AbsencesComponent } from './components/absences/absences.component';
import { EnseignantLoginComponent } from './components/enseignant/enseignant-login/enseignant-login.component';
import { AjouterEtudiantComponent } from './components/ajouter-etudiant/ajouter-etudiant.component'; // Ensure the path is correct

export const routes: Routes = [
  { path: 'etudiants', component: EtudiantsComponent },
  { path: 'absences', component: AbsencesComponent },
  { path: 'login', component: EnseignantLoginComponent },
  { path: 'ajouter-etudiant', component: AjouterEtudiantComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
