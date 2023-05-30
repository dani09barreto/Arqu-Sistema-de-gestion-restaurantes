import { TestBed } from '@angular/core/testing';

import { DespachadorServicesService } from './despachador-services.service';

describe('DespachadorServicesService', () => {
  let service: DespachadorServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DespachadorServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
