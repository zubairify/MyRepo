import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../employee.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  list : Employee[] = [];
  
  constructor(private service : EmployeeService, private router : Router) { }

  ngOnInit() {
    this.service.list().subscribe(data => this.list = data);
  }

  async deleteEmp(id : number) {
    var ans = confirm("Do you want to delete employee? " + id);
    if(ans)
      await this.service.delete(id);
  }

  editEmp(empid : number) {
    this.service.edit(empid);
  }

  sortById() {
    this.service.sortOnId().subscribe(data => this.list = data);
  }
}
