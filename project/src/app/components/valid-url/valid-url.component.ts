import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-valid-url',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './valid-url.component.html',
  styleUrl: './valid-url.component.scss'
})
export class ValidUrlComponent {

  @Input() urlValid: string = ''
  @Input() urlText: string = '';

}
