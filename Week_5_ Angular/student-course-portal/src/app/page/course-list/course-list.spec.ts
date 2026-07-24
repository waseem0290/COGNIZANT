import { ComponentFixture, TestBed } from '@angular/core/testing';

import { provideMockStore, MockStore } from '@ngrx/store/testing';

import { CourseList } from './course-list';


describe('CourseList', () => {


  let component: CourseList;

  let fixture: ComponentFixture<CourseList>;

  let store: MockStore;



  beforeEach(async()=>{


    await TestBed.configureTestingModule({

      imports:[

        CourseList

      ],


      providers:[


        provideMockStore({

          initialState:{

            course:{

              courses:[

                {

                  id:1,

                  name:'Data Structures',

                  code:'CS101',

                  credits:4,

                  gradeStatus:'passed'

                }

              ],

              loading:false,

              error:null

            }

          }

        })


      ]


    }).compileComponents();



    fixture =
      TestBed.createComponent(CourseList);


    component =
      fixture.componentInstance;


    store =
      TestBed.inject(MockStore);


  });




  it('should create',()=>{


    expect(component)
    .toBeTruthy();


  });




  it('should show loading indicator',()=>{


    store.setState({

      course:{

        courses:[],

        loading:true,

        error:null

      }

    });


    fixture.detectChanges();



    const text =
      fixture.nativeElement.textContent;



    expect(text)
    .toContain(
      'Loading courses'
    );


  });


});