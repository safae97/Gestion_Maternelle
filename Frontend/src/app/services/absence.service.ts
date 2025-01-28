
import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Etudiant {
  id?: number;
  nom: string;
  prenom: string;
  dateNaissance: Date;
  absences: Absence[];
  enseignantId?: number ; // Add this property

}

export interface Absence {
  id?: number;
  etudiantId: number | null ;
  enseignantId: number | null  ;
  dateAbsence: string;
  motif: string;
}
@Injectable({
  providedIn: 'root',
})
export class AbsenceService {
  private apiUrl = 'http://localhost:8080/absences';

  constructor(private http: HttpClient) {}

  getAllAbsences(): Observable<Absence[]> {
    return this.http.get<Absence[]>(this.apiUrl);
  }


  getAbsenceById(id: number): Observable<Absence> {
    return this.http.get<Absence>(`${this.apiUrl}/${id}`);
  }

  addAbsence(absence: Partial<Absence>, etudiantId: number, enseignantId: number): Observable<Absence> {
    const params = new HttpParams()
      .set('etudiantId', etudiantId.toString())
      .set('enseignantId', enseignantId.toString());

    return this.http.post<Absence>(this.apiUrl, absence, { params });
  }



  updateAbsence(id: number, absence: Absence): Observable<Absence> {
    return this.http.put<Absence>(`${this.apiUrl}/${id}`, absence);
  }

  deleteAbsence(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

