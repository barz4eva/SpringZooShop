package zoo.spring.project.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "animal_breed")
public class Breed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "breed_id")
	private int id;
	
	@Column(name = "breed")
	private String breed;
	
	@OneToMany(mappedBy = "breed")
	private Set<Animal> animal = new HashSet<>();
	
	public Breed() {}
	
	public Breed(String breed) {
		this.breed = breed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	

}
