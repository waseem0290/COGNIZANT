import { createFeatureSelector, createSelector } from '@ngrx/store';
import { CourseState } from './course.reducer';
// Get course feature state
export const selectCourseState =
  createFeatureSelector<CourseState>('course');
// Get all courses
export const selectAllCourses =
  createSelector(
    selectCourseState,
    (state) => state.courses
  );
// Get loading status
export const selectCoursesLoading =
  createSelector(
    selectCourseState,
    (state) => state.loading
  );
// Get error message
export const selectCoursesError =
  createSelector(
    selectCourseState,
    (state) => state.error
  );

