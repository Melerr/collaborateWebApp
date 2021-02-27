import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// const API_URL = 'http://localhost:8080/api/test/';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get('/api/test/all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get('/api/test/user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get('/api/test/mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get('/api/test/admin', { responseType: 'text' });
  }
}
