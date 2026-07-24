import { Component } from '@angular/core';
import { NotificationService } from '../../services/notification';


@Component({
 selector:'app-notification',
 standalone:true,
 imports:[],
 providers:[NotificationService],
 templateUrl:'./notification.html',
 styleUrl:'./notification.css'
})
export class Notification {


  message = '';


  constructor(
    private notificationService: NotificationService
  ){

    this.message =
    this.notificationService.showNotification();

  }


}