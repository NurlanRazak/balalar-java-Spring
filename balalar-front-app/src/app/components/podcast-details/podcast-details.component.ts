import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import {Podcast} from '../../podcast';
import {PodcastService} from '../../podcast_service/podcast.service';
import {Router, ActivatedRoute} from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { Pipe, PipeTransform } from '@angular/core';
import {CommonModule} from "@angular/common";
import {ActStatusPipe} from "../../ActStatus.pipe";
@Component({
  selector: 'app-podcast-details',
  templateUrl: './podcast-details.component.html',
  styleUrls: ['./podcast-details.component.css']
})

@NgModule({
  declarations:[ActStatusPipe], // <---
  imports:[CommonModule],
  exports:[ActStatusPipe] // <---
})
export class PodcastDetailsComponent implements OnInit {

  private podcast:Podcast;
  private data;


  constructor(private _podcastService:PodcastService, private _router:Router, private route:ActivatedRoute, public sanitizer: DomSanitizer) { }


  ngOnInit() {
    this.route.params.subscribe(params => {
      this._podcastService.getId(params['id']).subscribe((response)=>{
        this.data = response
        console.log(response)
      })
    });
    this.podcast = this._podcastService.getter();
  }
  processForm(){
    this._podcastService.getId(this.podcast.id).subscribe((podcast)=>{
      console.log(podcast);
    })
  }


}
