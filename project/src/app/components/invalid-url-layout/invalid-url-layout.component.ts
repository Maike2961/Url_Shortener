import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-invalid-url-layout',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './invalid-url-layout.component.html',
  styleUrl: './invalid-url-layout.component.scss'
})
export class InvalidUrlLayoutComponent {

  @Input() validUrl: boolean = false;
  @Input() validText: string = '';
}
