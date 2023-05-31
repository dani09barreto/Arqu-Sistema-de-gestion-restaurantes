import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignPopupComponent } from './sign-popup.component';

describe('SignPopupComponent', () => {
  let component: SignPopupComponent;
  let fixture: ComponentFixture<SignPopupComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SignPopupComponent]
    });
    fixture = TestBed.createComponent(SignPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
