import { Injectable } from '@angular/core';
import { Employee } from '../employee.model';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseUrl : string = "http://localhost:8080/emp-rest/rest";

  constructor(private router : Router, private http : HttpClient) { }

  save(emp : Employee) {
    this.http.post(this.baseUrl +"/add", emp).subscribe(
      data => data = emp);
  }

  list() {
    return this.http.get<Employee[]>(this.baseUrl+"/list");
  }

  delete(id : number) {
    this.http.delete(this.baseUrl+"/del/"+id).subscribe();
  }

  search(id : number) : Observable<Employee> {
    return this.http.get<Employee>(this.baseUrl+"/fetch/"+id);
  }

  edit(empid : number) {
    this.router.navigate(['edit'],{queryParams: {empid: empid}});
  }
  
  update(emp : Employee) {
    this.http.put(this.baseUrl +"/edit", emp).subscribe(
      data => data = emp);
  }

  sortOnId() {
    return this.http.get<Employee[]>(this.baseUrl+"/list");
  }
}
