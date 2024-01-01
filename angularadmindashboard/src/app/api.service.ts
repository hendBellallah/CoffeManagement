import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { user } from './model/user';

@Injectable({
  providedIn: 'root'
})
export class ApiService {


  constructor(private http:HttpClient) { }

  LoginUser(user:any){
    return this.http.post<any>('http://localhost:9090/users/login',user);
  }



  registerUser(user:any){
    return this.http.post('http://localhost:9090/users/register',user)
  }



   getAllUsers(): Observable<any> {
    return this.http.get('http://localhost:9090/users/all');
  }



  deleteUser(id: string) {
    return this.http.delete(`http://localhost:9090/users/${id}`);
  }

  getUser(id: any): Observable<any> {
    return this.http.get(`http://localhost:9090/users/${id}`);
  }


updateUser(id : any , data: any): Observable<any> {
  return this.http.put(`http://localhost:8080/api/users/${id}`, data);
}






}



