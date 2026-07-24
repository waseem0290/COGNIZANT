import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { Store } from '@ngrx/store';

import { CourseCard } from '../course-card/course-card';
import { Course } from '../../models/course.model';

import {
  Observable,
  Subject
} from 'rxjs';

import {
  switchMap
} from 'rxjs/operators';

import {
  loadCourses
} from '../../store/course/course.actions';

import {
  selectAllCourses,
  selectCoursesLoading,
  selectCoursesError
} from '../../store/course/course.selectors';

import {
  StudentService,
  Student
} from '../../services/student';



@Component({
  selector:'app-course-list',
  standalone:true,

  imports:[
    CommonModule,
    FormsModule,
    CourseCard
  ],

  templateUrl:'./course-list.html',

  styleUrl:'./course-list.css'
})


export class CourseList implements OnInit {


  courses$!: Observable<Course[]>;

  isLoading$!: Observable<boolean>;

  errorMessage$!: Observable<string | null>;



  selectedStudents: Student[] = [];


  courseSelected =
  new Subject<number>();


  searchTerm = '';

  selectedCourseId = 0;



  constructor(

    private store: Store,

    private studentService: StudentService

  ){}



  ngOnInit(){


    this.courses$ =
    this.store.select(selectAllCourses);



    this.isLoading$ =
    this.store.select(selectCoursesLoading);



    this.errorMessage$ =
    this.store.select(selectCoursesError);



    this.store.dispatch(
      loadCourses()
    );



    this.courseSelected

    .pipe(

      switchMap(courseId =>

        this.studentService
        .getStudentsByCourse(courseId)

      )

    )

    .subscribe({

      next:(students)=>{

        this.selectedStudents = students;

      }

    });



  }




  viewStudents(id:number){

    this.selectedCourseId = id;

    this.courseSelected.next(id);

  }




  trackByCourseId(
    index:number,
    course:Course
  ){

    return course.id;

  }




  onEnroll(courseId:number){

    this.selectedCourseId = courseId;

  }



  searchCourses(){

    console.log(
      'Searching:',
      this.searchTerm
    );

  }



}