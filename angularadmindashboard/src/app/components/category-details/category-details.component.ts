import { Component , OnInit, ViewChild} from '@angular/core';
import {CategoriesService} from '../../services/categories.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/model/category';
import { NgForm } from '@angular/forms';

class categoryDetails {
id:string="";
name: string = "";
}
@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent implements OnInit{
  updateCategoryForm: categoryDetails = new categoryDetails();

  @ViewChild("categoryDetails")
  categoryDetails!: NgForm;

  category = null;
  message = '';
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  isSubmitted: boolean = false;
  id: any;


  constructor(
     private categoryService:CategoriesService, 
     private router: Router,
     private route: ActivatedRoute) { }

  ngOnInit() : void {
    this.id = this.route.snapshot.params['id'];      
    this.getCategory();
    this.message = '';

  }
  
   getCategory() {       
    this.categoryService.getOne(this.id).subscribe((data : any) => {      
      if (data) {
        this.updateCategoryForm.id = data.id;
        this.updateCategoryForm.name = data.name;
      }
    },
      (error: any) => { });
  }

//-----------------------update hna----------
EditCategory(id: any, category: any) {
  this.isSubmitted = true;
  this.categoryService.update(id, category)
  .subscribe(
    res=>{
      this.router.navigate(['/categories']);
      console.log(res)
     
    },err=>{
      console.log(err)
    }
  )
  }
}