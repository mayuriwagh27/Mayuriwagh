import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
customers  = [];
  constructor(http: HttpClient) {
    http.get<any>('../../assets/customers.json').subscribe(data => {
      console.log(data);
      this.customers = data;
    }, err => {
      console.log(err);
    });
  }

ngOnInit() {
  }

}
