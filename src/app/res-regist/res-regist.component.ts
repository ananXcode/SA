import { Component, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { PARAMETERS } from '@angular/core/src/util/decorators';
import { HttpClient} from '@angular/common/http';
import { RegistService } from './../regist.service';

@Component({
  selector: 'app-res-regist',
  templateUrl: './res-regist.component.html',
  styleUrls: ['./res-regist.component.css']
})

export class ResRegistComponent implements OnInit {
  tel: number;
  rtel: number;
  rname: String;
  menus: '';
  catego: '';
  owa: '';
  promo: '';

  packAddress: any = {
    addressSelect: '',
    picurl: ''
  };

  owname: Array<any>;
  menu: Array<any>;
  category: Array<any>;
  promos: Array<any>;

  constructor(private httpClient: HttpClient, private registService: RegistService) { }
  ngOnInit() {
    this.getAllCategory();
    this.getAllMenu();
    this.getAllOwner();
    this.getAllPromo();
  }

  save() {
    if (this.owa === undefined || this.rname === '' || this.packAddress.addressSelect === ''
        || this.catego === undefined
        || this.menus === undefined || this.packAddress.addressSelect === undefined || this.rtel === undefined
        || this.promo === undefined) {
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
        this.httpClient.post('http://localhost:8080/restaurant/create/' + this.rname + '/'
         + this.catego + '/' + this.menus + '/' + this.owa + '/' + this.rtel + '/' + this.promo, this.packAddress).subscribe(
        data => {
            console.log('PUT Request is successful', data);
        },
        error => {
            console.log('---Error----', error);
             window.location.reload();
        }
        );
      }
  }
  getAllCategory() {
    this.registService.getAllCategory().subscribe(data => {
      this.category = data;
      console.log(this.category);
    });
  }
  getAllMenu() {
    this.registService.getAllMenu().subscribe(dataa => {
      this.menu = dataa;
      console.log(this.menu);
    });
  }
  getAllOwner() {
    this.registService.getAllOwner().subscribe(data => {
      this.owname = data;
      console.log(this.owname);
    });
  }
    getAllPromo() {
    this.registService.getAllPromo().subscribe(data => {
      this.promos = data;
      console.log(this.promos);
    });
  }

}

