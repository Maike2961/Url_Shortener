import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, tap } from 'rxjs';
import { IRequest } from '../interface/IRequest';
import { IResponse } from '../interface/IResponse';

@Injectable({
  providedIn: 'root'
})
export class UrlService {


  urlApi: string = "http://localhost:8080";

  constructor(private readonly http: HttpClient) { }

  post(request: IRequest): Observable<IResponse>{
    return this.http.post<IResponse>(`${this.urlApi}/shorten-url`, request).pipe(
      tap((value) => {
        const expiresAtTimestamp = new Date(value.expiresAt).getTime();
        sessionStorage.setItem("expiresAt", expiresAtTimestamp.toString());
      })
    )
  }
}
