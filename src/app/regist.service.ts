import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RegistService {
constructor(private http: HttpClient) {
  }
  public API = '//localhost:8080';
  getAllCategory(): Observable<any> {
    return this.http.get('//localhost:8080/categories');
  }
  getAllMenu(): Observable<any> {
    return this.http.get('//localhost:8080/showmenu');
  }
  getAllOwner(): Observable<any> {
    return this.http.get('//localhost:8080/showowner');
  }
  getAllPromo(): Observable<any> {
    return this.http.get('//localhost:8080/showPromo');
  }

}
