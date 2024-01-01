import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {ApiService} from '../../api.service';

@Component({
  selector: 'app-pages-register',
  templateUrl: './pages-register.component.html',
  styleUrls: ['./pages-register.component.css']
})
export class PagesRegisterComponent implements OnInit {
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private apiService:ApiService , private route:Router ) { }

  ngOnInit(): void {
    
  }
  registerUser(user:any)
  {
    this.apiService.registerUser(user)
    .subscribe(
      res=>{
        alert("User registred successfully")
        this.route.navigate(['/users']);
        console.log(res)
       
      },err=>{
        console.log(err)
      }
    )
  }


}
