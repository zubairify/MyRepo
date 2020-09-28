import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddComponent } from './add/add.component';
import { ListComponent } from './list/list.component';
import { SearchComponent } from './search/search.component';
import { EditComponent } from './edit/edit.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path : 'home', component : HomeComponent},
  {path : 'add', component : AddComponent},
  {path : 'list', component : ListComponent},
  {path : 'search', component : SearchComponent},
  {path : 'edit', component : EditComponent},
  {path : '', component : LoginComponent}, 
  {path : 'logout', component : LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
