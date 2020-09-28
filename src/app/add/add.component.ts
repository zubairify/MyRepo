import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { EmployeeService } from '../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  emp : Employee;

  constructor(private service : EmployeeService, private router : Router) {
    this.emp = new Employee;
  }

  ngOnInit() {
  }

  saveEmp() {
    this.service.save(this.emp);
    this.emp = new Employee();
    this.router.navigate(['list']);
  }
}
