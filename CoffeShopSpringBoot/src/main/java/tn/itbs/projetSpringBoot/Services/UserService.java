package tn.itbs.projetSpringBoot.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;
import tn.itbs.projectSpringBoot.DTO.LoginDTO;
import tn.itbs.projetSpringBoot.Entities.User;
import tn.itbs.projetSpringBoot.Repositories.UserRepo;
import tn.itbs.springBoot.Response.LoginResponse;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// -------------------------GET ALL Users-----------------------
		public List<User> findAll() {
			
			return userRepo.findAll();
		}
	
	//------------------------- ADD NEW USER -----------------------
		public ResponseEntity<String> ajouter(User u)
		{	userRepo.findById(u.getId())
						.ifPresentOrElse(
								x -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User already exsist !!!");},
								()-> {
								
									String encodedPassword = this.passwordEncoder.encode(u.getPassword());
						            u.setPassword(encodedPassword);
						            userRepo.save(u);});
			return 	ResponseEntity.ok("Added Successfully !");
		
		}
		
		//------------------------- LOGIN USER -----------------------
		public LoginResponse login(LoginDTO loginDTO)
		{	
			String msg="";
			User user1= userRepo.findByLogin(loginDTO.getLogin());
			
			if (user1 != null) {
				String password = loginDTO.getPassword();
				String encodedpassword =user1.getPassword();
				Boolean isPwdRight = passwordEncoder.matches(password, encodedpassword);
				
					if(isPwdRight) {
						Optional<User> user = userRepo.findOneByLoginAndPassword(loginDTO.getLogin(),encodedpassword );
							if (user.isPresent()) {
								return new LoginResponse("Login Success",true);	
							}else {
								return new LoginResponse("Login Failed",false);	
							}
							
					}else {
						return new LoginResponse("Password not match",false);	
					}
			}
		
			return new LoginResponse("Login does not exsist",false);	
		
		
		}

	//------------------------- DELETE User -----------------------
		public ResponseEntity<String> delete(int id) {
			userRepo.findById(id)
			.ifPresentOrElse(
					x -> { userRepo.delete(x);},
					()-> {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exsist");});
			return 	ResponseEntity.ok("Deleted Successfully ! ");
		}

	/*------------------------- UPDATE CATEGORY -----------------------
		@Transactional
		public ResponseEntity<String> modifier(int id, Category c) {
			userRepo.findById(id)
			.ifPresentOrElse(
					 x -> {
					 x.setName(c.getName()) ;
					 x.setListP(c.getListP());
					 },
					()-> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");});
				return 	ResponseEntity.ok("Updated Successfully !");
		}*/
		//------------------------- GET CATEGORY BY ID-----------------------
		public User findById(int id) {
		    return userRepo.findById(id)
		            .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
		}


		
		


		
	
	
	
	
}
