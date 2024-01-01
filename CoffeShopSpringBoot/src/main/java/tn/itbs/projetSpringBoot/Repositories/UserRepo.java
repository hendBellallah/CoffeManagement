package tn.itbs.projetSpringBoot.Repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.itbs.projetSpringBoot.Entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
	
    Optional<User> findOneByLoginAndPassword(String login, String password);
    
	User findByLogin(String login); 
		

}

