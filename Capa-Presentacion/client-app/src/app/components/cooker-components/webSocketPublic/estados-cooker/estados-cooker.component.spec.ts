import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstadosCookerComponent } from './estados-cooker.component';

describe('EstadosCookerComponent', () => {
  let component: EstadosCookerComponent;
  let fixture: ComponentFixture<EstadosCookerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EstadosCookerComponent]
    });
    fixture = TestBed.createComponent(EstadosCookerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
