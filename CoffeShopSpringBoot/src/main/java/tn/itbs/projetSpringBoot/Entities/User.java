package tn.itbs.projetSpringBoot.Entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50, nullable = false)
	private String login;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 150, nullable = false)
	private String password;
	
	@Column(length = 50, nullable = false)
	private String role;
	
	/*@JsonIgnore
	@OneToMany(mappedBy = "cat")
	private List<Product> listP=new ArrayList<Product>();
	
	public void addProduit (Product p, User cat)
	{  
		p.setCat(cat);
		listP.add(p);
		
		
	}*/
	
}
