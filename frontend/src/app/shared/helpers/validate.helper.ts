import {FormControl, FormGroup} from "@angular/forms";

/**
 * Helper class to enable validator error messages
 */
export class ValidateHelper {
  public static validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      const control = formGroup.get(field);

      if (control instanceof FormControl) {
        control.markAsTouched({ onlySelf: true });
      }

      else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }
}
