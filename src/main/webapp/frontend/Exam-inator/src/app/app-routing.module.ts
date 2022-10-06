import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { TakeExamComponent } from './take-exam/take-exam.component';
import { HomeComponent } from './views/home/home.component';
import { LiveListComponent } from './views/home/live-list/live-list.component';

const routes: Routes = [
  { path:'', component: LiveListComponent },
  { path: 'home', component: HomeComponent },
  { path: 'live-list', component: LiveListComponent },
  { path: 'take-exam', component: TakeExamComponent},
  { path: '**', component: PageNotFoundComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
