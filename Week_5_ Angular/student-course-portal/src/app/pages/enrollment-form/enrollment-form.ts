import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CourseService } from '../../services/course';


@Component({
  selector:'app-enrollment-form',
  standalone:true,
  imports:[
    FormsModule,
    CommonModule
  ],
  templateUrl:'./enrollment-form.html',
  styleUrl:'./enrollment-form.css'
})
export class EnrollmentForm {


studentName = '';

studentEmail = '';

courseId: any = '';

preferredSemester = 'Odd';

agreeToTerms = false;

submitted = false;


constructor(
  private courseService: CourseService
){}



onSubmit(form:any){


console.log(form.value);

console.log(form.valid);



if(form.valid){


const newCourse = {


name: this.studentName,


code: this.courseId,


credits: 3,


gradeStatus: 'pending' as 
'pending'


};



this.courseService
.createCourse(newCourse)
.subscribe({

next:(response)=>{


console.log(
'Course created:',
response
);


this.submitted = true;


},


error:(err)=>{


console.log(
'Error creating course:',
err
);


}


});


}



}



}