package tn.itbs.projetSpringBoot.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itbs.projectSpringBoot.DTO.LoginDTO;
import tn.itbs.projetSpringBoot.Entities.Category;
import tn.itbs.projetSpringBoot.Entities.User;
import tn.itbs.projetSpringBoot.Services.CategoryService;
import tn.itbs.projetSpringBoot.Services.UserService;
import tn.itbs.springBoot.Response.LoginResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	 @GetMapping("/{id}")
    public User getOne(@PathVariable int id){
        return userService.findById(id);
    }
	
	@GetMapping("/all")
	public List<User> findAll(){
		
	return userService.findAll();	
	}
	
	@PostMapping("/register")
	public void save(@RequestBody User u){
		
		userService.ajouter(u);	
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDto){
		
		LoginResponse loginResponse = userService.login(loginDto);	
		
		return ResponseEntity.ok(loginResponse);
				
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		
		return userService.delete(id);	
	}
	
	/*@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable int id,@RequestBody Category c){
		
		return userService.modifier(id,c);	
	}*/
}
