import { Component, OnInit } from '@angular/core';
import {Podcast} from '../../podcast';
import {Router} from '@angular/router';
import {PodcastService} from '../../podcast_service/podcast.service';
@Component({
  selector: 'app-podcast-form',
  templateUrl: './podcast-form.component.html',
  styleUrls: ['./podcast-form.component.css']
})
export class PodcastFormComponent implements OnInit {
  private podcast:Podcast;

  constructor(private _podcastService: PodcastService, private _router:Router) { }

  ngOnInit() {
    this.podcast=this._podcastService.getter();
  }
  processForm(){
    if(this.podcast.id===undefined){
      this._podcastService.createPodcast(this.podcast).subscribe((podcast)=>{
        console.log(podcast);
        this._router.navigate(['/podcastlist']);
      },(error)=>{
        console.log(error);  
      });
    }else{
      this._podcastService.updatePodcast(this.podcast).subscribe((podcast)=>{
        console.log(podcast);
        this._router.navigate(['/podcastlist']);
      },(error)=>{
        console.log(error);  
      });
    }
  }
}
