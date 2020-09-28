import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../employee.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  emp : Employee;

  constructor(private service : EmployeeService,
    private router : Router,
    private route : ActivatedRoute) { 
      this.emp = new Employee();
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
        this.service.search(params['empid']).subscribe(data => this.emp = data);
      });
  }

  async updateEmp() {
    await this.service.update(this.emp);
    this.router.navigate(['list']);
  }
}
