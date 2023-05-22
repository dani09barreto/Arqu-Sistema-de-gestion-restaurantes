import {MatDialog} from '@angular/material/dialog';
import { Component, EventEmitter, OnInit, Output, Inject } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';


@Component({
  selector: 'app-login-popup',
  templateUrl: './login-popup.component.html',
  styleUrls: ['./login-popup.component.css']
})
export class LoginPopupComponent {

  @Output() private update = new EventEmitter<string>();
  constructor(
    //private service:ServicioService,
     public dialogRef: MatDialogRef<LoginPopupComponent>) { }

  onNoClick(): void{
    this.dialogRef.close();
  }


}
