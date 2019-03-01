import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from './users';

@Injectable()
export class AuthenticationService{
  private registerUrl = "http://localhost:8080/users/sign-up";
  private loginUrl = "http://localhost:8080/login";
  private httpHeaders = {headers: new HttpHeaders({'Content-Type':'application/json'})};

  constructor(private http: HttpClient){
  }

  login(user: User){
    let formData: FormData = new FormData();
    formData.append('username', user.username);
    formData.append('password', user.password);
    return this.http.post(this.loginUrl, formData);
  }

  signUp(user: User){
    return this.http.post(this.registerUrl, user, this.httpHeaders);
  }

  isAuthenticated(): boolean{    
    let currentUser = this.getCurrentUser();
    return currentUser && currentUser.authdata;
  }

  getCurrentUser(){
    return JSON.parse(localStorage.getItem('currentUser'));
  }

  setCurrentUser(user: User){
    let userData = {authdata: btoa(`${user.username}:${user.password}`)}        
    localStorage.setItem("currentUser", JSON.stringify(userData));
  }
}
