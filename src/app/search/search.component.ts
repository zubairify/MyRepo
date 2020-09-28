import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  emp : Employee;
  id : number;

  constructor(private service : EmployeeService) { }

  ngOnInit() {
  }

  searchEmp() {
    this.service.search(this.id).subscribe(data => this.emp = data);
  }
}
