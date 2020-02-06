import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
error = null;
  constructor() { }
login(loginForm: NgForm) {
  console.log(loginForm.value);
  loginForm.reset();
}
  ngOnInit() {
  }

}
