import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdicionJuegosComponent } from './edicion-juegos.component';

describe('EdicionJuegosComponent', () => {
  let component: EdicionJuegosComponent;
  let fixture: ComponentFixture<EdicionJuegosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EdicionJuegosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EdicionJuegosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
