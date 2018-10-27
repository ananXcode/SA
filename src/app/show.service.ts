import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ShowService {

  constructor(private http: HttpClient) { }
  public API = '//localhost:8080';

  getAllRestaurant(): Observable<any> {
    return this.http.get('//localhost:8080/Restaurant');
  }
  ShowRestaurantInfo(rid) {
    return this.http.get('//localhost:8080/Restaurant/' + rid);
  }
}
