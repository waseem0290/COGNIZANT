import { Component, OnInit } from '@angular/core';
import { EnrollmentService } from '../../services/enrollment';
import { Course } from '../../models/course.model';
import { CommonModule } from '@angular/common';


@Component({
  selector:'app-student-profile',
  standalone:true,
  imports:[
    CommonModule
  ],
  templateUrl:'./student-profile.html',
  styleUrl:'./student-profile.css'
})
export class StudentProfile implements OnInit {


  enrolledCourses: Course[] = [];


  constructor(
    private enrollmentService: EnrollmentService
  ){}



  ngOnInit(){


    this.enrollmentService
    .getEnrolledCourses()
    .subscribe({

      next:(courses)=>{

        this.enrolledCourses = courses;

      },


      error:(err)=>{

        console.log(err);

      }

    });


  }


}