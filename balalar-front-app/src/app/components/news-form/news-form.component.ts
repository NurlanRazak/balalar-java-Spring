import { Component, OnInit } from '@angular/core';
import {News} from '../../news';
import {Router} from '@angular/router';
import {NewsService} from '../../news_service/news.service';


@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css']
})
export class NewsFormComponent implements OnInit {
  private news: News;

  constructor(private _newsService:NewsService, private _router:Router) { }

  ngOnInit() {
    this.news=this._newsService.getter();
  }
  processForm(){
    if(this.news.id===undefined){
      this._newsService.createNews(this.news).subscribe((news)=>{
        console.log(news);
        this._router.navigate(['/newslist']);
      },(error)=>{
        console.log(error);  
      });
    }else{
      this._newsService.updateNews(this.news).subscribe((news)=>{
        console.log(news);
        this._router.navigate(['/newslist']);
      },(error)=>{
        console.log(error);  
      });
    }
  }

}
