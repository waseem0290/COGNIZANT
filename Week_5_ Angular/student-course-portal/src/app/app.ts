import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './components/header/header';
import { AsyncPipe, NgIf } from '@angular/common';
import { LoadingService } from './services/loading';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    Header,
    AsyncPipe,
    NgIf
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {


  constructor(
    public loadingService: LoadingService
  ) {}


}