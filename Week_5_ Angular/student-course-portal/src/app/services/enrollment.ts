import { Injectable } from '@angular/core';
import { CourseService } from './course';
import { Course } from '../models/course.model';
import { forkJoin, Observable } from 'rxjs';


@Injectable({
  providedIn:'root'
})
export class EnrollmentService {


private enrolledCourseIds:number[] = [];


constructor(
 private courseService:CourseService
){}



enroll(courseId:number){

 if(!this.enrolledCourseIds.includes(courseId)){

  this.enrolledCourseIds.push(courseId);

 }

}



unenroll(courseId:number){

 this.enrolledCourseIds =
 this.enrolledCourseIds.filter(
  id => id !== courseId
 );

}



isEnrolled(courseId:number){

 return this.enrolledCourseIds.includes(courseId);

}



getEnrolledCourses():Observable<Course[]>{


 return forkJoin(

  this.enrolledCourseIds.map(

   id =>
   this.courseService.getCourseById(id)

  )

 );


}


}