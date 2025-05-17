import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutUrlComponent } from './layout-url.component';

describe('LayoutUrlComponent', () => {
  let component: LayoutUrlComponent;
  let fixture: ComponentFixture<LayoutUrlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LayoutUrlComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LayoutUrlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
