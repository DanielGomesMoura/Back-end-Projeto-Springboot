import { first } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Course } from './../model/courses';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private readonly API = '/assets/courses.json';

  constructor(private httpCliente: HttpClient) { }

  list(){
    return this.httpCliente.get<Course[]>(this.API)
    .pipe(
      tap(Course => console.log(Course))
    );
  }
}
