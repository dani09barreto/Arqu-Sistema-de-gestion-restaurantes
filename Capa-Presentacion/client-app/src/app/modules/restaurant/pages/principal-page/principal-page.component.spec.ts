import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrincipalPageComponent } from './principal-page.component';

describe('PrincipalPageComponent', () => {
  let component: PrincipalPageComponent;
  let fixture: ComponentFixture<PrincipalPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrincipalPageComponent]
    });
    fixture = TestBed.createComponent(PrincipalPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
