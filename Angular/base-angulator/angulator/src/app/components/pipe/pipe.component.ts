import { Component } from '@angular/core';

@Component({
  selector: 'app-pipe',
  templateUrl: './pipe.component.html',
  styleUrls: ['./pipe.component.css']
})
export class PipeComponent {
  title = 'Pipe';
  documentation = 'https://angular.io/guide/pipes';
  pipeList = 'https://angular.io/api?type=pipe';
  public currentTime: Date;

  constructor() {
    setInterval(() => { this.currentTime = new Date(); }, 1000);
  }
}