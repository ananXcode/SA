import { ShowService } from './../show.service';
import { RegistService } from './../regist.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PARAMETERS } from '@angular/core/src/util/decorators';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-show-res',
  templateUrl: './show-res.component.html',
  styleUrls: ['./show-res.component.css']
})
export class ShowResComponent implements OnInit {

  restaurants: Object;

  constructor(private data: ShowService, private route: ActivatedRoute) {
  }
  ngOnInit() {
    this.data.getAllRestaurant().subscribe(data => this.restaurants = data);

      }
  }
