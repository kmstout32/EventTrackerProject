import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Kibble } from '../models/kibble';
// talking to rest api

@Injectable({
  providedIn: 'root',
})
export class KibbleService {
  private baseUrl = 'http://localhost:8080/';
  private url = this.baseUrl + 'api/kibbles';

  constructor(private http: HttpClient) {}
  index(): Observable<Kibble[]> {
    return this.http.get<Kibble[]>(this.url + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error('KibbleService.index(): error retrieving kibble: ' + err)
        );
      })
    );
  }

  show(kibbleId: number): Observable<Kibble> {
    return this.http.get<Kibble>(this.url + '/' + kibbleId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error('KibbleService.show(): error retrieving kibbles: ' + err)
        );
      })
    );
  }

  create(kibble: Kibble): Observable<Kibble> {
    return this.http.post<Kibble>(this.url, kibble).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error('KibbleService.index(): error retrieving kibble: ' + err)
        );
      })
    );
  }

  update(kibble: Kibble): Observable<Kibble> {
    return this.http.put<Kibble>(this.url + '/' + kibble.id, kibble).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error('kibbleService.index(): error retrieving kibbles: ' + err)
        );
      })
    );
  }

  destory(kibbleId: number): Observable<void> {
    return this.http.delete<void>(this.url + '/' + kibbleId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('TodoService.index(): error retrieving Todos: ' + err)
        );
      })
    );
  }
}
