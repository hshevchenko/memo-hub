import {Injectable} from '@angular/core';
import {User} from '../../users/users';

@Injectable()
export class AppContext{

  static getCurrentUser(): User{
    return JSON.parse(localStorage.getItem("currentUser")) as User;
  }
}
