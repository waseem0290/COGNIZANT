import { createFeatureSelector, createSelector } from '@ngrx/store';
import { EnrollmentState } from './enrollment.reducer';
import { selectAllCourses } from '../course/course.selectors';
// Get enrollment state
export const selectEnrollmentState =
  createFeatureSelector<EnrollmentState>('enrollment');
// Get enrolled course ids
export const selectEnrolledIds =
  createSelector(
    selectEnrollmentState,
    (state) => state.enrolledCourseIds
  );
// Cross-slice selector
// Combines enrollment state + course state
export const selectEnrolledCourses =
  createSelector(
    selectAllCourses,
    selectEnrolledIds,
    (courses, enrolledIds) =>
      courses.filter(
        course => enrolledIds.includes(course.id)
      )
  );

  