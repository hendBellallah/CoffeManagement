package tn.itbs.projetSpringBoot.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;
import tn.itbs.projetSpringBoot.Entities.Category;
import tn.itbs.projetSpringBoot.Repositories.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	// -------------------------GET ALL CATEGORIES-----------------------
		public List<Category> findAll() {
			
			return categoryRepo.findAll();
		}
	
	//------------------------- ADD NEW CATEGORY -----------------------
		public ResponseEntity<String> ajouter(Category c)
		{	categoryRepo.findById(c.getId())
						.ifPresentOrElse(
								x -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category already exsist !!!");},
								()-> {categoryRepo.save(c);});
			return 	ResponseEntity.ok("Added Successfully !");
		
		}

	//------------------------- DELETE CATEGORY -----------------------
		public ResponseEntity<String> delete(int id) {
			categoryRepo.findById(id)
			.ifPresentOrElse(
					x -> { categoryRepo.delete(x);},
					()-> {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category does not exsiste");});
			return 	ResponseEntity.ok("Deleted Successfully ! ");
		}

	//------------------------- UPDATE CATEGORY -----------------------
		@Transactional
		public ResponseEntity<String> modifier(int id, Category c) {
			categoryRepo.findById(id)
			.ifPresentOrElse(
					 x -> {
					 x.setName(c.getName()) ;
					 x.setListP(c.getListP());
					 },
					()-> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");});
				return 	ResponseEntity.ok("Updated Successfully !");
		}
		//------------------------- GET CATEGORY BY ID-----------------------
		public Category findById(int id) {
		    return categoryRepo.findById(id)
		            .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + id));
		}


		
		


		
	
	
	
	
}
