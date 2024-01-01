import { Component, OnInit, ElementRef } from '@angular/core';
import {ApiService} from '../../api.service';
import {ActivatedRoute,Router } from '@angular/router';
import { user } from 'src/app/model/user';
@Component({
  selector: 'app-users-data',
  templateUrl:'./users-data.component.html',
  styleUrls: ['./users-data.component.css']
})
export class UsersDataComponent implements OnInit {
  usersList?: user[]=[];
  message ='';
  // _id: any;
  // category :any;
  i: number =0;

  constructor(
    private elementRef: ElementRef,
    private apiService:ApiService, 
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit() : void {
    this.retrieveUsers();
    //this.user._id;

    var s = document.createElement("script");
    s.type = "text/javascript";
    s.src = "../assets/js/main.js";
    this.elementRef.nativeElement.appendChild(s);
  }




  retrieveUsers(): void {
    this.apiService.getAllUsers()
      .subscribe(
        data => {
          this.usersList = data;
          console.log(this.usersList);
        },
        error => {
          console.log(error);
        });
  }

//-------------------deleete ----------
  deleteUser(idUser : any) {
    if(window.confirm('Do you want to delete this user?')) {
    this.apiService.deleteUser(idUser)
      .subscribe(
        response => {
          console.log(response);
          this.retrieveUsers();

        },
        error => {
          console.log(error);
    });
  }

  }

}
