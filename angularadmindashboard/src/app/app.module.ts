import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './layouts/header/header.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { SidebarComponent } from './layouts/sidebar/sidebar.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { UsersDataComponent } from './components/users-data/users-data.component';
import { UsersProfileComponent } from './pages/users-profile/users-profile.component';
import { PagesRegisterComponent } from './pages/pages-register/pages-register.component';
import { PagesLoginComponent } from './pages/pages-login/pages-login.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UserDetailsComponent } from './components/user-details/user-details.component';
import { AddCategoryComponent } from './components/add-category/add-category.component';
import { CategoriesListComponent } from './components/categories-list/categories-list.component';
import { CategoryDetailsComponent } from './components/category-details/category-details.component';
import { ProductsListComponent } from './components/products-list/products-list.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    DashboardComponent,
    UsersDataComponent,
    UsersProfileComponent,
    PagesRegisterComponent,
    PagesLoginComponent,
    UserDetailsComponent,
    AddCategoryComponent,
    CategoriesListComponent,
    CategoryDetailsComponent,
    ProductsListComponent
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
