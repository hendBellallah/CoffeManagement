import { Component , OnInit, ViewChild} from '@angular/core';
import {ApiService} from '../../api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { user } from 'src/app/model/user';
import { NgForm } from '@angular/forms';

class userDetails {
id:string="";
username: string = "";
email: string = "";
password :string ="";
role: string = "";
}

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit{

 updateUserForm: userDetails = new userDetails();

  @ViewChild("userDetails")
  userDetails!: NgForm;

  user = null;
  message = '';
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  isSubmitted: boolean = false;
  id: any;


  constructor(
     private apiService:ApiService, 
     private router: Router,
     private route: ActivatedRoute) { }

  ngOnInit() : void {
    this.id = this.route.snapshot.params['id'];      
    this.getUser();
    this.message = '';

  }

   getUser() {       
    this.apiService.getUser(this.id).subscribe((data : any) => {      
      if (data) {
        this.updateUserForm.id = data._id;
        this.updateUserForm.username = data.username;
        this.updateUserForm.email = data.email;
        this.updateUserForm.password = data.password;
        this.updateUserForm.role = data.role;
      }
    },
      (error: any) => { });
  }

//-----------------------update hna----------
EditUser(id: any, user: any) {
  this.isSubmitted = true;
  this.apiService.updateUser(id, user)
    .subscribe(
      res=> {
        console.log(res)
        this.router.navigate(['/users']);
      },err=>{
        console.log(err)
      }
    )
  }
}





