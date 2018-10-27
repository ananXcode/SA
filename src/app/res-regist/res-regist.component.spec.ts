import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResRegistComponent } from './res-regist.component';

describe('ResRegistComponent', () => {
  let component: ResRegistComponent;
  let fixture: ComponentFixture<ResRegistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResRegistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResRegistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
