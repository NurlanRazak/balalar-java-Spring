import { Component, OnInit } from '@angular/core';
import { NewsService } from '../../news_service/news.service';
import { News } from '../../news';
import { Router, ActivatedRoute } from '@angular/router';
import { PodcastService } from '../../podcast_service/podcast.service';
import { Podcast } from '../../podcast';
import {UserService} from '../../shared_service/user.service';
import {User} from '../../user';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {
  private news:News;
  private data;
  private podcasts:Podcast;
  private users:User[];
  
  constructor(private _newsService:NewsService, private _router:Router, private route:ActivatedRoute, private _podcastService:PodcastService, private _userService:UserService) { }

  ngOnInit() {
    this._newsService.getIds().subscribe((news)=>{
      console.log(news);
      this.news=news;
    },(error)=>{
      console.log(error);
    })

    this._userService.getIds().subscribe((users)=>{
      console.log(users);
      this.users=users;
    },(error)=>{
      console.log(error);
    })

    this._podcastService.getIds().subscribe((podcasts)=>{
      console.log(podcasts);
      this.podcasts=podcasts;
    },(error)=>{
      console.log(error);
    })

  }

  getUser(user){
    this._userService.setter(user);
    this._router.navigate(['/Blog/Details']);
  }
}
