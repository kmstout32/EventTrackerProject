import { TestBed } from '@angular/core/testing';

import { KibbleService } from './kibble.service';

describe('KibbleService', () => {
  let service: KibbleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KibbleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
