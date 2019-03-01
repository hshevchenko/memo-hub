import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../security/auth.service';
import {Router, ActivatedRoute, Params} from '@angular/router';
import { map } from "rxjs/operators";
import {User} from './users';

@Component({
  selector: 'login',
  templateUrl: 'login.html',
  styleUrls: ['../../../app.component.css']
})

export class LoginComponent implements OnInit{
  user: User = new User();
  badCredentials: boolean =  false;
  returnUrl: string;

  constructor(private service: AuthenticationService,
              private router: Router,
              private route: ActivatedRoute){}
  ngOnInit(){
    this.route.queryParams.pipe(map(p => p['returnUrl'])).subscribe(res => this.returnUrl = res);
  }

  login(){

    this.service.login(this.user).subscribe(
      res => {
        this.badCredentials = false;
        this.service.setCurrentUser(this.user);
        //this.router.navigate(['/']);
        return true;
      },
      err => {
        this.badCredentials = true;
        console.log(err);
      });
    }
}
