import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Course as CourseModel } from '../models/course.model';
import { Observable, catchError, throwError, tap, retry } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class CourseService {


  private apiUrl = 'http://localhost:3000/courses';


  constructor(
    private http: HttpClient
  ) {}


getCourses(): Observable<CourseModel[]> {
  return this.http
  .get<CourseModel[]>(this.apiUrl)
  .pipe(
    tap(courses => {
      console.log(
        'Courses loaded:',
        courses.length
      );
    }),
    map(courses =>
      courses.filter(
        course => course.credits > 0
      )
    ),
    retry(2),
    catchError(err => {
      console.error(err);
      return throwError(
        () => new Error(
          'Failed to load courses. Please try again.'
        )
      );
    })
  );
}


  getCourseById(id: number): Observable<CourseModel> {

    return this.http.get<CourseModel>(
      `${this.apiUrl}/${id}`
    );

  }


  createCourse(course: Omit<CourseModel, 'id'>): Observable<CourseModel> {

    return this.http.post<CourseModel>(
      this.apiUrl,
      course
    );

  }


  updateCourse(
    id: number,
    course: CourseModel
  ): Observable<CourseModel> {

    return this.http.put<CourseModel>(
      `${this.apiUrl}/${id}`,
      course
    );

  }


  deleteCourse(id: number): Observable<void> {

    return this.http.delete<void>(
      `${this.apiUrl}/${id}`
    );

  }

}