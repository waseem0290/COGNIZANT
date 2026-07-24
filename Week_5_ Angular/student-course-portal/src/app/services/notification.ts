import { Injectable } from '@angular/core';


@Injectable()
export class NotificationService {


  message = 'Notification service working';


  showNotification(){

    return this.message;

  }


}