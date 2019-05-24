import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared_service/user.service';
import {User} from '../../user';
import{Router}  from '@angular/router';


@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {

  private anti:Number;
  private users:User[];
  constructor(private _userService:UserService, private _router:Router) { }

  ngOnInit() {
    this._userService.getIds().subscribe((users)=>{
        console.log(users);
        this.users=users;
      },(error)=>{
        console.log(error);
      })
  }



  getUser(user){
    this._userService.setter(user);
    this._router.navigate(['/Blog/Details']);
  }
}
