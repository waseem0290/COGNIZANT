import { Pipe, PipeTransform } from '@angular/core';
@Pipe({
 name:'creditLabel',
 standalone:true
})
export class CreditLabelPipe implements PipeTransform {
 transform(value:number){
  return value === 1
      ? '1 Credit'
      : value
      ? value + ' Credits'
      : 'No Credits';

 }
}
