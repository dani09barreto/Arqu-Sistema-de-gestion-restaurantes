import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrincipalLocalComponent } from './principal-local.component';

describe('PrincipalLocalComponent', () => {
  let component: PrincipalLocalComponent;
  let fixture: ComponentFixture<PrincipalLocalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrincipalLocalComponent]
    });
    fixture = TestBed.createComponent(PrincipalLocalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
