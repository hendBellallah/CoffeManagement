import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {ApiService} from '../../api.service';

@Component({
  selector: 'app-pages-login',
  templateUrl: './pages-login.component.html',
  styleUrls: ['./pages-login.component.css']
})
export class PagesLoginComponent implements OnInit {

  constructor(private apiService:ApiService, private route:Router) { }

  ngOnInit(): void {
  }

  LoginUser(user:any)
  {
    this.apiService.LoginUser(user)
    .subscribe((res :any) =>{
      console.log(res);
      if(res.message == "Login does not exsist")
      { 
        alert("Login does not exsist")
      }
      else if(res.message =="Login Success")
      {
        this.route.navigate(['/dashboard']);
      }
      else
      {
        alert("Incorrect Email or Password")
      }

    });
  }

  // res=>{
  //   this.route.navigate(['/dashboard']);
  //   console.log(res)
  // },err=>{
  //   console.log(err)
  // }

}
