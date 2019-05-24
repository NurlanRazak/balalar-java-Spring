import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs';
import {News} from '../news';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable({
  providedIn: 'root'
})
export class NewsService {
  private baseUrl:string = 'http://localhost:8080/api';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private news:News;
  constructor(private _http:Http) { }

  getIds(){

    return this._http.get(this.baseUrl+'/news',this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  getId(id:Number){
    return this._http.get(this.baseUrl+'/news/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  deleteNews(id:Number){

    return this._http.delete(this.baseUrl+'/news/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  createNews(news:News){

    return this._http.post(this.baseUrl+'/news',JSON.stringify(news),  this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
   
   updateNews(news:News){

    return this._http.put(this.baseUrl+'/news',JSON.stringify(news),  this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }

  errorHandler(error:Response){

    return Observable.throw(error||"SERVER ERROR");
  }
  setter(news:News){
    this.news = news;
  }
  getter(){
    return this.news;
  }

  
}
