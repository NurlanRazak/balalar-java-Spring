import { Component, OnInit } from '@angular/core';
import {PodcastService} from '../../podcast_service/podcast.service';
import {Podcast} from '../../podcast';
import {Router} from '@angular/router';


@Component({
  selector: 'app-listpodcast',
  templateUrl: './listpodcast.component.html',
  styleUrls: ['./listpodcast.component.css']
})
export class ListpodcastComponent implements OnInit {
  private podcasts:Podcast[];

  constructor(private _podcastService:PodcastService, private _router:Router) { }

  ngOnInit() {
    this._podcastService.getIds().subscribe((podcasts)=>{
      console.log(podcasts);
      this.podcasts=podcasts;
    },(error)=>{
      console.log(error);
    })
  }


  deletePodcast(podcast){
    this._podcastService.deletePodcast(podcast.id).subscribe((data)=>{
        this.podcasts.splice(this.podcasts.indexOf(podcast),1);
    },(error)=>{
      console.log(error);
    });
  }
  updatePodcast(podcast){  
    this._podcastService.setter(podcast);
    this._router.navigate(['/podcast/create']);


  }
  newPodcast(){
  let podcast = new Podcast();
   this._podcastService.setter(podcast);
    this._router.navigate(['/podcast/create']);
  
  }
}
