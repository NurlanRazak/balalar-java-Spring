import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListpodcastComponent } from './listpodcast.component';

describe('ListpodcastComponent', () => {
  let component: ListpodcastComponent;
  let fixture: ComponentFixture<ListpodcastComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListpodcastComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListpodcastComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
