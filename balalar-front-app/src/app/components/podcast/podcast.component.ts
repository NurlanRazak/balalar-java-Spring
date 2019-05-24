import { Component, OnInit } from '@angular/core';
import { PodcastService } from '../../podcast_service/podcast.service';
import { Podcast } from '../../podcast';
import { Router, ActivatedRoute }  from '@angular/router';
@Component({
  selector: 'app-podcast',
  templateUrl: './podcast.component.html',
  styleUrls: ['./podcast.component.css']
})
export class PodcastComponent implements OnInit {

  private podcasts:Podcast;
  private data;
  constructor(private _podcastService:PodcastService, private _router:Router, private route: ActivatedRoute) { }

  ngOnInit() {
    // this.route.params.subscribe(params => {
    //   //params['id']
    //   this._podcastService.getId(params['id']).subscribe((response)=>{
    //     this.data = response
    //     console.log(response)
    //   })
    // });


    this._podcastService.getIds().subscribe((podcasts)=>{
      console.log(podcasts);
      this.podcasts=podcasts;
    },(error)=>{
      console.log(error);
    })
    //  this.podcast=this._podcastService.getter();
  }
  // processForm(){
  //   this._podcastService.getId(this.podcasts.id).subscribe((podcasts)=>{
  //     console.log(podcasts);
  //   })
  // }

}
