import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListofstoresComponent } from './listofstores.component';

describe('ListofstoresComponent', () => {
  let component: ListofstoresComponent;
  let fixture: ComponentFixture<ListofstoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListofstoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListofstoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
