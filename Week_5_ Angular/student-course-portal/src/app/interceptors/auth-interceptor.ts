import { HttpInterceptorFn } from '@angular/common/http';


export const authInterceptor: HttpInterceptorFn = (req, next) => {


  const modifiedRequest = req.clone({

    setHeaders: {

      Authorization: 'Bearer mocktoken-12345'

    }

  });


  return next(modifiedRequest);


};