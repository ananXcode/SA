import { Component, OnInit } from '@angular/core';
import { ShowService } from '../show.service';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { PARAMETERS } from '@angular/core/src/util/decorators';

@Component({
  selector: 'app-resinfo',
  templateUrl: './resinfo.component.html',
  styleUrls: ['./resinfo.component.css']
})
export class ResinfoComponent implements OnInit {

  restaurantInfo: Object;

  constructor(private data: ShowService, private route: ActivatedRoute, private httpClient: HttpClient) {
    this.route.params.subscribe( params => this.restaurantInfo = params.rid);
   }
  ngOnInit() {
    this.data.ShowRestaurantInfo(this.restaurantInfo).subscribe(
      data => this.restaurantInfo = data);
  }

}
