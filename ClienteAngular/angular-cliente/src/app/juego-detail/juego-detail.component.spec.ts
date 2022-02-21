import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JuegoDetailComponent } from './juego-detail.component';

describe('JuegoDetailComponent', () => {
  let component: JuegoDetailComponent;
  let fixture: ComponentFixture<JuegoDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JuegoDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JuegoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
