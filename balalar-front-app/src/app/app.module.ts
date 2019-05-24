import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HttpModule} from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListuserComponent } from './components/listuser/listuser.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { UserService } from './shared_service/user.service';
import { MainpageComponent } from './components/mainpage/mainpage.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { AboutComponent } from './components/about/about.component';
import { CoursesComponent } from './components/courses/courses.component';
import { PodcastComponent } from './components/podcast/podcast.component';
import { AuthorComponent } from './components/author/author.component';
import { BlogComponent } from './components/blog/blog.component';
import { ContactComponent } from './components/contact/contact.component';
import { BlogDetailsComponent } from './components/blog-details/blog-details.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { UserComponent } from './components/user/user.component';
import { PmComponent } from './components/pm/pm.component';
import { AdminComponent } from './components/admin/admin.component';
import { httpInterceptorProviders } from './auth/auth-interceptor';
import { NewsService } from './news_service/news.service';
import { PodcastService } from './podcast_service/podcast.service';
import { ListpodcastComponent } from './components/listpodcast/listpodcast.component';
import { PodcastFormComponent } from './components/podcast-form/podcast-form.component';
import { ListnewsComponent } from './components/listnews/listnews.component';
import { NewsFormComponent } from './components/news-form/news-form.component';
import { PodcastDetailsComponent } from './components/podcast-details/podcast-details.component';
import { NewsDetailsComponent } from './components/news-details/news-details.component';


const appRoutes:Routes=[
  { path: '', redirectTo: '/Home', pathMatch: 'full' },
  //{path:'', component:ListuserComponent},
  {path:'op', component:UserFormComponent},
  {path:'podcastlist', component:ListpodcastComponent},
  {path:'Podcast/Details/:id', component:PodcastDetailsComponent},
  {path:'newslist', component:ListnewsComponent},
  {path:'News/Details/:id', component:NewsDetailsComponent},
  {path:'podcast/create', component:PodcastFormComponent},
  {path:'news/create', component:NewsFormComponent},
  {path:'Home', component:MainpageComponent },
  {path:'About', component:AboutComponent },
  {path:'News', component:CoursesComponent },
  {path:'Podcast', component:PodcastComponent },
  {path:'Author', component:AuthorComponent },
  {path:'Blog', component:BlogComponent },
  {path:'Blog/Details/:id', component:BlogDetailsComponent },
  {path:'Contact', component:ContactComponent },
  {path: 'home',component: HomeComponent},
  {path: 'user', component: UserComponent},
  {path: 'pm', component: PmComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'admin/crud', component: ListuserComponent},
  {path: 'auth/login', component: LoginComponent},
  {path: 'signup', component: RegisterComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserFormComponent,
    MainpageComponent,
    FooterComponent,
    HeaderComponent,
    AboutComponent,
    CoursesComponent,
    PodcastComponent,
    AuthorComponent,
    BlogComponent,
    ContactComponent,
    BlogDetailsComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    UserComponent,
    PmComponent,
    AdminComponent,
    ListpodcastComponent,
    PodcastFormComponent,
    ListnewsComponent,
    NewsFormComponent,
    PodcastDetailsComponent,
    NewsDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    PodcastDetailsComponent,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService, httpInterceptorProviders, PodcastDetailsComponent],
  bootstrap: [AppComponent],
})
export class AppModule { }
