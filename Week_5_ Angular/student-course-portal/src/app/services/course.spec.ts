import { TestBed } from '@angular/core/testing';

import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';

import { CourseService } from './course';


describe('CourseService', () => {


  let service: CourseService;

  let httpMock: HttpTestingController;



  beforeEach(() => {


    TestBed.configureTestingModule({

      imports:[

        HttpClientTestingModule

      ],

      providers:[

        CourseService

      ]

    });



    service =
      TestBed.inject(CourseService);


    httpMock =
      TestBed.inject(HttpTestingController);


  });



  afterEach(() => {

    httpMock.verify();

  });



  it('should create service', () => {

    expect(service).toBeTruthy();

  });



  it('should get courses', () => {


    const mockCourses = [

      {

        id:1,

        name:'Data Structures',

        code:'CS101',

        credits:4,

        gradeStatus:'passed'

      },


      {

        id:2,

        name:'Operating Systems',

        code:'CS102',

        credits:3,

        gradeStatus:'passed'

      }

    ];



    service.getCourses()

    .subscribe(courses => {


      expect(courses.length)
      .toBe(2);


    });



    const request =
      httpMock.expectOne(
        'http://localhost:3000/courses'
      );


    expect(
      request.request.method
    )
    .toBe('GET');



    request.flush(mockCourses);


  });



it('should handle server error', () => {


  service.getCourses()

  .subscribe({

    next: () => {

      throw new Error('Expected error');

    },


    error: (error) => {

      expect(error.message)
        .toBe(
          'Failed to load courses. Please try again.'
        );

    }

  });



  for(let i = 0; i < 3; i++) {


    const request =
      httpMock.expectOne(
        'http://localhost:3000/courses'
      );


    request.flush(

      'Server error',

      {
        status: 500,
        statusText: 'Server Error'
      }

    );

  }


});


});