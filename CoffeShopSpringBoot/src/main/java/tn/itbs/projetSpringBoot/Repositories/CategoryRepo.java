package tn.itbs.projetSpringBoot.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.itbs.projetSpringBoot.Entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>{

		// Affiche la liste des categories ou le nom est egale a nom
		List<Category> findByName(String name);
		

}

