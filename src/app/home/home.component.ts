import { Component, OnInit } from '@angular/core';
import { Login } from '../login.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  uname : string;
  constructor() { }

  ngOnInit() {
    this.uname = localStorage.getItem("uname");
  }

}
