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

import tn.itbs.projetSpringBoot.Entities.Category;
import tn.itbs.projetSpringBoot.Services.CategoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	 @GetMapping("/{id}")
    public Category getOne(@PathVariable int id){
        return categoryService.findById(id);
    }
	
	@GetMapping("/all")
	public List<Category> findAll(){
		
	return categoryService.findAll();	
	}
	
	@PostMapping("/add")
	public void save(@RequestBody Category c){
		
		categoryService.ajouter(c);	
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		
		return categoryService.delete(id);	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable int id,@RequestBody Category c){
		
		return categoryService.modifier(id,c);	
	}
}
