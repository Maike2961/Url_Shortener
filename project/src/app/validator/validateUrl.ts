import { AbstractControl, FormGroup, ValidationErrors, ValidatorFn } from "@angular/forms";


export const validateUrl: ValidatorFn = (FormGroup: AbstractControl): ValidationErrors | null =>{

    const url: string = FormGroup.get('url')?.value;


    if(typeof url === 'string' && (url.startsWith("http://") || url.startsWith("https://"))){
        return null;
    }else{
        return {invalidUrl: true}
    }
}