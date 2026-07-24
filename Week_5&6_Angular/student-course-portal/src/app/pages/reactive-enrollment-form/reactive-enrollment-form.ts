import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CanComponentDeactivate } 
from '../../guards/unsavedchanges-guard';
import {
 FormBuilder,
 FormGroup,
 FormArray,
 FormControl,
 AbstractControl,
 ValidationErrors,
 Validators,
 ReactiveFormsModule
} from '@angular/forms';

function noCourseCode(control: AbstractControl): ValidationErrors | null {

  const value = control.value;
  

  if(value && value.startsWith('XX')){
    return {
      noCourseCode:true
    };
  }

  return null;

}
function simulateEmailCheck(control: AbstractControl): Promise<ValidationErrors | null> {

  return new Promise((resolve)=>{

    setTimeout(()=>{

      if(control.value && control.value.includes('test@')){

        resolve({
          emailTaken:true
        });

      }
      else{

        resolve(null);

      }

    },800);

  });

}

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports:[
  ReactiveFormsModule,
  CommonModule
  ],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css'
})
export class ReactiveEnrollmentForm implements OnInit, CanComponentDeactivate {
  canDeactivate(): boolean {

    return !this.enrollForm.dirty;
  }
  

  enrollForm!: FormGroup;


  constructor(private fb: FormBuilder) {}


  ngOnInit() {

    this.enrollForm = this.fb.group({

      studentName: [
        '',
        [
          Validators.required,
          Validators.minLength(3)
        ]
      ],


      studentEmail:[
        '',
        [
          Validators.required,
          Validators.email
        ],
        [
          simulateEmailCheck
        ]
      ],


      courseId:[
       null,
       [
        Validators.required,
        noCourseCode
       ]
      ],


      preferredSemester: [
        'Odd',
        Validators.required
      ],


      agreeToTerms: [
        false,
        Validators.requiredTrue
      ],
      
      additionalCourses: this.fb.array([])
    });

  }
  
  onSubmit(){

  console.log("Form Value:");
  console.log(this.enrollForm.value);


  console.log("Raw Value:");
  console.log(this.enrollForm.getRawValue());

  }
get additionalCourses(): FormArray<FormControl> {

  return this.enrollForm.get('additionalCourses') as FormArray<FormControl>;

}

  addCourse(){
    this.additionalCourses.push(
    new FormControl('', Validators.required)
    );
  }
  removeCourse(index:number){
    this.additionalCourses.removeAt(index);
  }


}