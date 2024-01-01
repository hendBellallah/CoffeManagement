package tn.itbs.projetSpringBoot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.itbs.projetSpringBoot.Entities.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{

}
