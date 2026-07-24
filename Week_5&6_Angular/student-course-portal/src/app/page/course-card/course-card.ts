import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnChanges,
  SimpleChanges,
  OnInit
} from '@angular/core';

import { CommonModule } from '@angular/common';

import { CreditLabelPipe } from '../../pipes/credit-label-pipe';

import { Router } from '@angular/router';

import { Store } from '@ngrx/store';

import { Observable } from 'rxjs';

import {
  enrollInCourse,
  unenrollFromCourse
} from '../../store/enrollment/enrollment.actions';

import {
  selectEnrolledIds
} from '../../store/enrollment/enrollment.selectors';



@Component({
  selector: 'app-course-card',
  standalone:true,

  imports:[
    CommonModule,
    CreditLabelPipe
  ],

  templateUrl:'./course-card.html',

  styleUrl:'./course-card.css'
})


export class CourseCard implements OnChanges, OnInit {


  @Input() course!: any;


  @Output()
  enrollRequested =
  new EventEmitter<number>();



  enrolledIds$!: Observable<number[]>;


  enrolledIds:number[] = [];



  isExpanded = false;



  constructor(

    private store: Store,

    private router: Router

  ){}



  ngOnInit(){


    this.enrolledIds$ =
    this.store.select(selectEnrolledIds);



    this.enrolledIds$
    .subscribe(ids => {

      this.enrolledIds = ids;

    });


  }




  enroll(){


    if(this.isCourseEnrolled()){


      this.store.dispatch(

        unenrollFromCourse({

          courseId:this.course.id

        })

      );


    }

    else{


      this.store.dispatch(

        enrollInCourse({

          courseId:this.course.id

        })

      );


    }


    this.enrollRequested.emit(
      this.course.id
    );


  }





  isCourseEnrolled(){


    return this.enrolledIds.includes(
      this.course.id
    );


  }




  goToDetails(){

    this.router.navigate([

      'courses',

      this.course.id

    ]);

  }





  ngOnChanges(changes: SimpleChanges){


    console.log(

      changes['course']?.previousValue,

      changes['course']?.currentValue

    );


  }





  toggleExpand(){

    this.isExpanded = !this.isExpanded;

  }





  get cardClasses(){


    return {

      'card--enrolled':
      this.isCourseEnrolled(),


      'card--full':
      this.course.credits >= 4,


      'expanded':
      this.isExpanded

    };


  }



}