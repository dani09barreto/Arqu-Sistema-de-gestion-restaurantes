import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrincipalGeneralComponent } from './principal-general.component';

describe('PrincipalGeneralComponent', () => {
  let component: PrincipalGeneralComponent;
  let fixture: ComponentFixture<PrincipalGeneralComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrincipalGeneralComponent]
    });
    fixture = TestBed.createComponent(PrincipalGeneralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
