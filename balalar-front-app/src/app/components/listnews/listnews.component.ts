import { Component, OnInit } from '@angular/core';
import {NewsService} from '../../news_service/news.service';
import {News} from '../../news';
import {Router} from '@angular/router';

@Component({
  selector: 'app-listnews',
  templateUrl: './listnews.component.html',
  styleUrls: ['./listnews.component.css']
})
export class ListnewsComponent implements OnInit {
  private newss:News[];

  constructor(private _newsService:NewsService, private _router:Router) { }

  ngOnInit() {
    this._newsService.getIds().subscribe((newss)=>{
      console.log(newss);
      this.newss=newss;
    }, (error)=>{
      console.log(error);
    })
  }
  deleteNews(news){
    this._newsService.deleteNews(news.id).subscribe((data)=>{
      this.newss.splice(this.newss.indexOf(news),1);
    }, (error)=>{
      console.log(error);
    });
  }
  updateNews(news){
    this._newsService.setter(news);
    this._router.navigate(['/news/create']); 
  }
  newNews(){
    let news = new News();
    this._newsService.setter(news);
    this._router.navigate(['/news/create']);
  }
}
