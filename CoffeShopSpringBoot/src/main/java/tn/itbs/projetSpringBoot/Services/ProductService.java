package tn.itbs.projetSpringBoot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;
import tn.itbs.projetSpringBoot.Entities.Product;
import tn.itbs.projetSpringBoot.Repositories.CategoryRepo;
import tn.itbs.projetSpringBoot.Repositories.ProductRepo;
@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private CategoryRepo categorieRepo ;
	
	// -------------------------GET ALL Products-----------------------
		public List<Product> findAll() {
			
			return productRepo.findAll();
		}
	
	//------------------------- ADD NEW Product -----------------------
		public ResponseEntity<String> ajouter(Product p, int idc)
		{	categorieRepo.findById(idc)
						.ifPresentOrElse(
								c -> { 
								p.setCat(c);
								productRepo.save(p);
								},
								()-> {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product already exsist");});
			return 	ResponseEntity.ok("Added Successfully !");
		
		}

	//------------------------- DELETE Product -----------------------
		public ResponseEntity<String> delete(int id) {
			productRepo.findById(id)
			.ifPresentOrElse(
					x -> { productRepo.delete(x);},
					()-> {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category does not exsiste");});
			return 	ResponseEntity.ok("Deleted Successfully ! ");
		}

	//------------------------- UPDATE Product -----------------------
		@Transactional
		public ResponseEntity<String> modifier(int id, Product p) {
			productRepo.findById(id)
			.ifPresentOrElse(
					 x -> {
					 x.setName(p.getName()) ;
					 x.setPrice(p.getPrice());
					 x.setCat(p.getCat());
					 //productRepo.save(x);
					 },
					()-> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");});
				return 	ResponseEntity.ok("Updated Successfully !");
		}
}
