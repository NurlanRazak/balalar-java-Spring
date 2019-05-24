import { Component, OnInit } from '@angular/core';
import { News } from '../../news';
import {NewsService} from '../../news_service/news.service';
import {Router, ActivatedRoute} from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { Pipe, PipeTransform } from '@angular/core';
import {CommonModule} from "@angular/common";
import {ActStatusPipe} from "../../ActStatus.pipe";

@Component({
  selector: 'app-news-details',
  templateUrl: './news-details.component.html',
  styleUrls: ['./news-details.component.css']
})
export class NewsDetailsComponent implements OnInit {

  private news:News;
  private data;

  constructor(private _newsService:NewsService, private _router:Router, private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this._newsService.getId(params['id']).subscribe((response)=>{
        this.data = response
        console.log(response)
      })
    });
    this.news = this._newsService.getter();
  }
  processForm(){
    this._newsService.getId(this.news.id).subscribe((news)=>{
      console.log(news);
    })
  }

}
