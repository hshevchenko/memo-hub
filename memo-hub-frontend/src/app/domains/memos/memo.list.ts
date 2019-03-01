import {Component, OnInit} from '@angular/core';
import {Memo} from './memo';
import {MemoService} from './memo.service';

@Component({
  selector: 'memos',
  templateUrl: 'memo.list.html',
    styleUrls: ['../../app.component.css']
})

export class MemoListComponent implements OnInit{
  memos: Memo[];
  newMemo: Memo;

  constructor(private service: MemoService){
  }

  ngOnInit(){
    this.findAll();
  }

  findAll(){
    this.service.findAll().subscribe(res => {
      this.memos = res as Memo[];
      console.log(this.memos);
    },
    error => this.handleError(error));
  }

  findByUser(){
    console.log('Calls service to get memos by user');
    this.service.findByUser();
  }

  add(){
    this.newMemo = new Memo();
  }

  save(memo: Memo){
    this.service.save(memo).subscribe(updatedMemo => {
      if(memo.id == null){
        this.memos.push(updatedMemo as Memo);
        this.newMemo = null;
      }
      memo.inEdit = false;
    },
    error => this.handleError(error));
  }

  cancel(memo: Memo){
    memo.inEdit = false;
    if(memo.id == null){
      this.newMemo = null;
    }
  }

  delete(memo: Memo){
    if(confirm('Do you really want to delete this memo?')){
      this.service.delete(memo).subscribe(res => {
        this.memos = this.memos.filter(m => m.id !== memo.id);
        console.log(this.memos);

      });
    }
  }

  handleError(error: any): Promise<Array<any>>{
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

  test(){
    let filteredMemos  = this.memos.filter(m => m.id !== '5c38ee72815b4774d8403af0');
    console.log(filteredMemos);
  }
}
