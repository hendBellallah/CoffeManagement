package tn.itbs.projetSpringBoot.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.itbs.projetSpringBoot.Entities.Product;
import tn.itbs.projetSpringBoot.Services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	/*@GetMapping("/all/{id}")
	public List<Category> findOne(@PathVariable int id){
		
	 return categoryService.findById(id);	
	}*/
	
	@GetMapping("/all")
	public List<Product> findAll(){
		
	return productService.findAll();	
	}
	
	@PostMapping("/add")
	public void save(@RequestBody Product p,@RequestParam int idc){
		
		productService.ajouter(p,idc);	
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		
		return productService.delete(id);	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable int id,@RequestBody Product p){
		
		return productService.modifier(id,p);	
	}
}
