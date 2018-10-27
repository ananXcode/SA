import { TestBed } from '@angular/core/testing';

import { ResinfoService } from './resinfo.service';

describe('ResinfoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ResinfoService = TestBed.get(ResinfoService);
    expect(service).toBeTruthy();
  });
});
