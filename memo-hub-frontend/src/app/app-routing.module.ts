import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MemoListComponent} from './domains/memos/memo.list';
import {AuthenticationGuard} from './domains/platform/security/auth.guard';
import {LoginComponent} from './domains/users/login';

const routes: Routes = [
    {path: '', redirectTo:'memos', pathMatch: 'full'},
    {path: 'memos', component: MemoListComponent, canActivate: [AuthenticationGuard]},
    {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
