import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CourseService } from '../../services/course';
import { CourseSummaryWidget } 
from '../../components/course-summary-widget/course-summary-widget';
import { Notification } from '../../components/notification/notification';
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [FormsModule,CourseSummaryWidget,Notification],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit, OnDestroy {
  constructor(private courseService: CourseService) {}
  portalName = 'Student Course Portal';
  isPortalActive = true;
  message = '';
  searchTerm = '';
  coursesCount = 0;

  // [property] is one-way from component to DOM.
  // [(ngModel)] is two-way between component and DOM.

  ngOnInit() {

  this.courseService
  .getCourses()
  .subscribe({

    next: (courses) => {

      this.coursesCount = courses.length;

    },

    error: (err) => {

      console.log(err);

    }

  });


  console.log('HomeComponent initialised - courses loaded');

}

  ngOnDestroy() {
    console.log('HomeComponent destroyed');
  }

  onEnrollClick() {
    this.message = 'Enrollment opened!';
  }
}