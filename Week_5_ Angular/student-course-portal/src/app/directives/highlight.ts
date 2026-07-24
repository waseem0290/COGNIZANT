import {
  Directive,
  ElementRef,
  HostListener,
  Input
} from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {

  @Input() appHighlight = 'yellow';

  private originalColor = '';

  constructor(private el: ElementRef) {}

  @HostListener('mouseenter')
  mouseEnter() {

    const card = this.el.nativeElement.querySelector('.card');

    if (card) {

      this.originalColor = card.style.backgroundColor;

      card.style.backgroundColor = this.appHighlight;

    }

  }


  @HostListener('mouseleave')
  mouseLeave() {

    const card = this.el.nativeElement.querySelector('.card');

    if (card) {

      card.style.backgroundColor = this.originalColor;

    }

  }

}