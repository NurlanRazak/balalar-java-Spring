import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared_service/user.service';
import {User} from '../../user';
import {Router, ActivatedRoute}  from '@angular/router';


@Component({
  selector: 'app-blog-details',
  templateUrl: './blog-details.component.html',
  styleUrls: ['./blog-details.component.css']
})
export class BlogDetailsComponent implements OnInit {

  private user:User;
  private data;
  constructor(private _userService:UserService, private _router:Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
    //params['id']
    this._userService.getId(params['id']).subscribe((response)=>{
      this.data = response
      console.log(response)
    })
  });
    this.user=this._userService.getter();
  }

  processForm(){
    this._userService.getId(this.user.id).subscribe((user)=>{
      console.log(user);
    })
  }
  
}
