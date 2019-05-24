import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs';
import{User}  from '../user';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl:string='http://localhost:8080/api';
  private headers = new Headers({'Content-Type':'application/json', 'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0YXJhbnRpbm9reiIsImlhdCI6MTU1ODQxNjEzNywiZXhwIjoxNTU4NTAyNTM3fQ.RWUTRajy0sPMTSB99k-BBaX7VkqR-ARA0Jb0yT64XH0PKV2erztLfxukwpQTJ6uUFEs9gJnSvhpbWtgPqdfgfA'});
  private options = new RequestOptions({headers:this.headers});
  private user:User;
  constructor(private _http:Http) { }

  getIds(){

    return this._http.get(this.baseUrl+'/main',this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  getId(id:Number){
    return this._http.get(this.baseUrl+'/main/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }

  deleteUser(id:Number){

    return this._http.delete(this.baseUrl+'/main/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }


  createUser(user:User){

    return this._http.post(this.baseUrl+'/main',JSON.stringify(user),  this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
   
   updateUser(user:User){

    return this._http.put(this.baseUrl+'/main',JSON.stringify(user),  this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }

  errorHandler(error:Response){

    return Observable.throw(error||"SERVER ERROR");
  }
  setter(user:User){
    this.user=user;
  }

 getter(){
   return this.user;
 }
}
