import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-layout-url',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './layout-url.component.html',
  styleUrl: './layout-url.component.scss'
})
export class LayoutUrlComponent {
  @Input() btnDisabled: boolean = true;
  @Input() btnText: string = '';
  @Output() onSubmit = new EventEmitter();

  submit(): void{
    this.onSubmit.emit();
  }

}
