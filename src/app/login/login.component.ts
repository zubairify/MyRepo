import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { resolve } from 'url';
import { Login } from '../login.model';
import { UserService } from '../services/user.service';
import { User } from '../user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login : Login;
  user : User;
  roles : string[];

  constructor(private service : UserService, private router : Router) { 
    this.login = new Login();
    this.roles = ["Admin","User","Guest"];
  }
  
  ngOnInit(): void {
    localStorage.setItem("user", null);
  }
  
  async loggedIn() {
    await this.service.login(this.login).then(data => this.user = data);
    
    localStorage.setItem("user", JSON.stringify(this.user));
    localStorage.setItem("uname", this.user.name);
    this.router.navigate(['home']);
  }

}
