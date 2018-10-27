import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResinfoComponent } from './resinfo.component';

describe('ResinfoComponent', () => {
  let component: ResinfoComponent;
  let fixture: ComponentFixture<ResinfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResinfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
