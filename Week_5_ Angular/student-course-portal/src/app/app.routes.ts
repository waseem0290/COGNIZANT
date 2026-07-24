import { Routes } from '@angular/router';
import { Home } from './page/home/home';
import { CourseList } from './page/course-list/course-list';
import { StudentProfile } from './page/student-profile/student-profile';
import { CourseDetail } from './pages/course-detail/course-detail';
import { NotFound } from './pages/not-found/not-found';
import { CoursesLayout } 
from './pages/courses-layout/courses-layout';
import { authGuard } from './guards/auth-guard';
import { unsavedchangesGuard } from './guards/unsavedchanges-guard';
export const routes: Routes = [
  {
    path:'',
    component:Home
  },
  {
    path:'courses',
    component:CoursesLayout,
    children:[
      {
        path:'',
        component:CourseList
      },
      {
        path:':id',
        component:CourseDetail
      }
    ]
  },
  {
  path:'profile',
  component:StudentProfile,
  canActivate:[authGuard]
},
  {
    path:'enroll',
    canActivate:[authGuard],
    loadComponent: () =>
    import('./pages/enrollment-form/enrollment-form')
      .then(
      m => m.EnrollmentForm
    )
  },
  {
    path:'enroll-reactive',
    canDeactivate:[
      unsavedchangesGuard
    ],
    loadComponent: () =>
    import('./pages/reactive-enrollment-form/reactive-enrollment-form')
    .then(m => m.ReactiveEnrollmentForm)
  },
  {
    path:'**',
    component:NotFound
  }
];

