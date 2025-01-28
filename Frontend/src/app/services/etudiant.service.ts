import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Etudiant {
  id?: number;
  nom: string;
  prenom: string;
  dateNaissance: Date;
  absences: Absence[];
  enseignantId?: number; // Add this property

}

export interface Absence {
  id?: number;
  etudiantId: number ;
  enseignantId: number ;
  dateAbsence: string;
  motif: string;
}

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {
  private apiUrl = 'http://localhost:8080/etudiants';

  constructor(private http: HttpClient) {}

  getEtudiants(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  addEtudiant(etudiant: Etudiant, enseignantId: number): Observable<Etudiant> {
    return this.http.post<Etudiant>(`${this.apiUrl}?enseignantId=${enseignantId}`, etudiant); // Send enseignantId as query param
  }


  updateEtudiant(etudiant: Etudiant): Observable<Etudiant> {
    return this.http.put<Etudiant>(this.apiUrl, etudiant);
  }

  deleteEtudiant(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
