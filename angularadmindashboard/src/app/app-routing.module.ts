import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { UsersDataComponent } from './components/users-data/users-data.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';
import { PagesLoginComponent } from './pages/pages-login/pages-login.component';
import { PagesRegisterComponent } from './pages/pages-register/pages-register.component';
import { UsersProfileComponent } from './pages/users-profile/users-profile.component';
import { CategoriesListComponent } from './components/categories-list/categories-list.component';
import { AddCategoryComponent } from './components/add-category/add-category.component';
import { CategoryDetailsComponent } from './components/category-details/category-details.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'users', component: UsersDataComponent },
  { path: 'users/:id', component: UserDetailsComponent },
  { path: 'login', component: PagesLoginComponent },
  { path: 'register', component: PagesRegisterComponent },
  { path: 'user-profile', component: UsersProfileComponent },
  { path: 'categories', component: CategoriesListComponent },
  { path: 'addCategory', component: AddCategoryComponent },
  { path: 'categories/:id', component: CategoryDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
