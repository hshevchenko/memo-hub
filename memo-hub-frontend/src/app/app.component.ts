import { Component } from '@angular/core';
import { AuthenticationService } from './domains/users/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  constructor(private authService: AuthenticationService){

  }

  logout(){
    this.authService.logout();
    window.location.reload();
  }
}
