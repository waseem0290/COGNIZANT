import { vi } from 'vitest';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';

import { provideMockStore } from '@ngrx/store/testing';

import { CourseCard } from './course-card';


describe('CourseCard', () => {

  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;


  const mockCourse = {
    id: 1,
    name: 'Data Structures',
    code: 'CS101',
    credits: 4,
    gradeStatus: 'passed'
  };


  beforeEach(async () => {

    await TestBed.configureTestingModule({

      imports: [
        CourseCard
      ],

      providers: [

        provideMockStore({

          initialState: {

            enrollment: {

              enrolledCourseIds: []

            }

          }

        })

      ]

    }).compileComponents();


    fixture = TestBed.createComponent(CourseCard);

    component = fixture.componentInstance;


  });



  it('should create', () => {

    expect(component).toBeTruthy();

  });



  it('should display course name from input', () => {


    component.course = mockCourse;


    fixture.detectChanges();


    const heading =
      fixture.debugElement.query(
        By.css('h3')
      );


    expect(
      heading.nativeElement.textContent
    )
    .toContain(
      'Data Structures'
    );


  });



  it('should emit enrollRequested event', () => {


    component.course = mockCourse;


    vi.spyOn(
      component.enrollRequested,
      'emit'
    );


    fixture.detectChanges();


    component.enroll();


    expect(
      component.enrollRequested.emit
    )
    .toHaveBeenCalledWith(1);


  });



  it('should test ngOnChanges', () => {


    vi.spyOn(
      console,
      'log'
    );


    component.ngOnChanges({

      course: {

        previousValue: null,

        currentValue: mockCourse,

        firstChange: true,

        isFirstChange: () => true

      }

    });


    expect(
      console.log
    )
    .toHaveBeenCalled();


  });


});