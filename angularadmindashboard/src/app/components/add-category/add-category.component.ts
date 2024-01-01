import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {CategoriesService} from '../../services/categories.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit{
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  constructor(private categorieService:CategoriesService , private route:Router ) { }

  ngOnInit(): void {
    
  }
  createCategory(category:any)
  {
    this.categorieService.create(category)
    .subscribe(
      res=>{
        this.route.navigate(['/categories']);
        console.log(res)
       
      },err=>{
        console.log(err)
      }
    )
  }

}
