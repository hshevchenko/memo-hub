/** The Basic Authentication Interceptor intercepts http requests
from the application to add basic authentication credentials to the Authorization header
if the user is logged in.
*/
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import {AuthenticationService} from '../../users/auth.service';
import { Inject } from '@angular/core';

export class BasicAuthenticationInterceptor implements HttpInterceptor{

    constructor(@Inject(AuthenticationService) private service: AuthenticationService){
    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {        
        if(this.service.isAuthenticated()){
            let currentUser = this.service.getCurrentUser();
            request = request.clone({
                setHeaders: {
                    Authorization: `Basic ${currentUser.authdata}`
                }
            });
        }        
        
        return next.handle(request);
    }
}
