import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';

export interface Enseignant {
  id: number;
  username: string;
  email: string;
  password: string;

}
@Injectable({
  providedIn: 'root'
})
export class EnseignantService {

  private apiUrl = 'http://localhost:8080/enseignants';

  constructor(private http: HttpClient) {}

  registerEnseignant(enseignant: Enseignant): Observable<Enseignant> {
    return this.http.post<Enseignant>(`${this.apiUrl}/register`, enseignant);
  }

  login(username: string, password: string): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded');
    const body = `username=${username}&password=${password}`;
    return this.http.post(`${this.apiUrl}/login`, body, { headers });
  }


}
