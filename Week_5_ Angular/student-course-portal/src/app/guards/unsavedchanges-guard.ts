import { CanDeactivateFn } from '@angular/router';


export interface CanComponentDeactivate {

  canDeactivate: () => boolean;

}


export const unsavedchangesGuard: CanDeactivateFn<CanComponentDeactivate> =
(component) => {


  return component.canDeactivate()
    || window.confirm(
      'You have unsaved changes. Leave?'
    );


};