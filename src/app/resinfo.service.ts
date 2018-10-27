import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ResinfoService {

  constructor(private http: HttpClient) { }
  public API = '//localhost:8080';

  ShowRestaurantInfo(rid) {
    return this.http.get('//localhost:8080/Restaurant/' + rid);
  }
}
