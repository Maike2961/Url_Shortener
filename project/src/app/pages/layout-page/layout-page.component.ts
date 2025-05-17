import { Component, OnInit } from '@angular/core';
import { LayoutUrlComponent } from '../../components/layout-url/layout-url.component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { UrlService } from '../../service/url.service';
import { validateUrl } from '../../validator/validateUrl'
import { InvalidUrlLayoutComponent } from '../../components/invalid-url-layout/invalid-url-layout.component';
import { IRequest } from '../../interface/IRequest';
import { IResponse } from '../../interface/IResponse';
import { ValidUrlComponent } from '../../components/valid-url/valid-url.component';

@Component({
  selector: 'app-layout-page',
  standalone: true,
  imports: [LayoutUrlComponent, ReactiveFormsModule, InvalidUrlLayoutComponent, ValidUrlComponent],
  templateUrl: './layout-page.component.html',
  styleUrl: './layout-page.component.scss'
})
export class LayoutPageComponent implements OnInit{

  formUrl!: FormGroup
  type: string = "text"
  url: string = ''
  placeholder: string = "Type Here Your Url"

  constructor(private service: UrlService){
    this.formUrl = new FormGroup({
      url: new FormControl('', [Validators.required])
    }, {validators: validateUrl})
  }


  submit(): void{

    const request: IRequest = {
      url: this.formUrl.value.url
    };

    if(request.url){
      this.service.post(request).subscribe({
        next: (value: IResponse) =>{
          this.url = value.url;
          this.formUrl.reset();
        },
        error: (err) => {
          console.error(err)
        }
      });
    }else{
      this.url = this.placeholder
    }
  }

  ngOnInit(): void {
      const expiresAt = this.expiresAt()
      if(expiresAt){
        this.url = 'Link expirado!';
      }
  }

  private expiresAt(): boolean{
    const date = sessionStorage.getItem("expiresAt");
    if(date && Date.now() > Number(date)){
      sessionStorage.clear()
      return true;
    }
    return false;
  }
}
