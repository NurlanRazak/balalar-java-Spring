import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs';
import {Podcast} from '../podcast';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable({
  providedIn: 'root'
})
export class PodcastService {
  private baseUrl:string = 'http://localhost:8080/api';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private podcast:Podcast;
  constructor(private _http:Http) { }

  getIds(){

    return this._http.get(this.baseUrl+'/podcast',this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  getId(id:Number){
    return this._http.get(this.baseUrl+'/podcast/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  deletePodcast(id:Number){

    return this._http.delete(this.baseUrl+'/podcast/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }


  createPodcast(podcast:Podcast){

    return this._http.post(this.baseUrl+'/podcast',JSON.stringify(podcast),  this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
   
   updatePodcast(podcast:Podcast){

    return this._http.put(this.baseUrl+'/podcast',JSON.stringify(podcast),  this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }

  errorHandler(error:Response){

    return Observable.throw(error||"SERVER ERROR");
  }
  setter(podcast:Podcast){
    this.podcast = podcast;
  }
  getter(){
    return this.podcast;
  }
}
