import { Component, OnInit, ElementRef } from '@angular/core';
import {CategoriesService} from '../../services/categories.service';
import {ActivatedRoute,Router } from '@angular/router';
import { Category } from 'src/app/model/category';


@Component({
  selector: 'app-categories-list',
  templateUrl: './categories-list.component.html',
  styleUrls: ['./categories-list.component.css']
})
export class CategoriesListComponent implements OnInit{
  categoriesList?: Category[]=[];
  message ='';
  // _id: any;
  // category :any;
  i: number =0;

  constructor(
    private elementRef: ElementRef,
    private categorieService:CategoriesService, 
    private router: Router,
    private route: ActivatedRoute) { }


  ngOnInit(): void {
    this.retrieveCategories();
    //this.category._id;
    
    var s = document.createElement("script");
    s.type = "text/javascript";
    s.src = "../assets/js/main.js";
    this.elementRef.nativeElement.appendChild(s);
  }
  retrieveCategories(): void {
    this.categorieService.getAll()
      .subscribe(
        data => {
          this.categoriesList = data;
          console.log(this.categoriesList);
        },
        error => {
          console.log(error);
        });
  }

//-------------------deleete ----------
  deleteCategorie(idCat : any) {
    if(window.confirm('Do you want to delete this category?')) {
    this.categorieService.delete(idCat)
      .subscribe(
        response => {
          console.log(response);
          this.retrieveCategories();

        },
        error => {
          console.log(error);
    });
  }

  }
}
