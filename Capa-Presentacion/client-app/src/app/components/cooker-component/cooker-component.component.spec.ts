import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CookerComponentComponent } from './cooker-component.component';

describe('CookerComponentComponent', () => {
  let component: CookerComponentComponent;
  let fixture: ComponentFixture<CookerComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CookerComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CookerComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
