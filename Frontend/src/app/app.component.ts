import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { EtudiantsComponent } from './components/etudiants/etudiants.component';
import { HttpClientModule } from '@angular/common/http';
import {AbsencesComponent} from './components/absences/absences.component';
import {EnseignantLoginComponent} from './components/enseignant/enseignant-login/enseignant-login.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,CommonModule,EtudiantsComponent,AbsencesComponent,EnseignantLoginComponent,HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Gestion Maternelle';
}
