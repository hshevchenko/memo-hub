import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import {MemoListComponent} from './domains/memos/memo.list';
import {LoginComponent} from './domains/platform/security/login';

import {MemoService} from './domains/memos/memo.service';
import {BasicAuthenticationInterceptor} from './domains/platform/security/basic.auth.interceptor';
import {AuthenticationService} from './domains/platform/security/auth.service';
import {AppContext} from './domains/platform/security/app.context';

@NgModule({
  declarations: [
    AppComponent,
    MemoListComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    MemoService,
    AuthenticationService,
    AppContext,
    {provide: HTTP_INTERCEPTORS, useClass: BasicAuthenticationInterceptor, multi: true}

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
