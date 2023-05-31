import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CookerComponent } from './cooker.component';

describe('CookerComponent', () => {
  let component: CookerComponent;
  let fixture: ComponentFixture<CookerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CookerComponent]
    });
    fixture = TestBed.createComponent(CookerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
