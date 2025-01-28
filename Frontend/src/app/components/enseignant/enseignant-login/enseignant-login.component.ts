import { Component } from '@angular/core';
import { Router } from '@angular/router'; // Import Router
import { EnseignantService } from '../../../services/enseignant.service';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';


@Component({
  selector: 'app-enseignant-login',
  templateUrl: './enseignant-login.component.html',
  styleUrls: ['./enseignant-login.component.css'],
  standalone: true,
  imports: [FormsModule, CommonModule], // Include CommonModule for directives like *ngIf
})
export class EnseignantLoginComponent {
  username = '';
  password = '';
  errorMessage = '';

  constructor(private enseignantService: EnseignantService, private router: Router) {}

  login() {
    this.enseignantService.login(this.username, this.password).subscribe(
      (response) => {
        console.log('Login successful:', response);
        this.router.navigate(['/etudiants']);
      },
      (error) => {
        console.error('Login failed:', error);
        this.errorMessage = 'Invalid username or password';
      }
    );
  }

}
