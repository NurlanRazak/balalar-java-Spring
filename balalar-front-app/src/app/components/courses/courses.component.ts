import { Component, OnInit } from '@angular/core';
import {  NewsService } from '../../news_service/news.service';
import { News } from '../../news';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  private news:News;
  private data;

  constructor(private _newsService:NewsService, private _router:Router, private route:ActivatedRoute) { }

  ngOnInit() {
    this._newsService.getIds().subscribe((news)=>{
      console.log(news);
      this.news=news;
    },(error)=>{
      console.log(error);
    })
  }

}
