import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Memo} from './memo';
import {AppContext} from '../platform/security/app.context';

@Injectable()
export class MemoService{
  private httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};
  private baseUri: string = "http://localhost:8080/memos";

  constructor(private http: HttpClient){
  }

  findAll(){
    return this.http.get(this.baseUri + "/all", {withCredentials: true});
  }

  findByUser(){
    console.log(AppContext.getCurrentUser());
  }
  save(memo:Memo){
    if(memo.id != null){
      return this.http.post(this.baseUri, memo, this.httpOptions);
    }
    else{
      return this.http.put(this.baseUri + '/' +memo.id, memo, this.httpOptions);
    }
  }

  delete(memo: Memo){
    const url = this.baseUri + '/' +memo.id;
    return this.http.delete(url);
  }

  handleError(error: any): Promise<Array<any>>{
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
