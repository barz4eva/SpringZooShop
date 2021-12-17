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
@Table(name = "animal_type")
public class AnimalType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "type_id")
	private int id;
	
	@Column(name = "animal_type")
	private String animalType;
	
	@OneToMany(mappedBy = "type")
	private Set<Animal> animal = new HashSet<>();
	
	@OneToMany(mappedBy = "type")
	private Set<Food> food = new HashSet<>();
	
	@OneToMany(mappedBy = "type")
	private Set<Toys> toys = new HashSet<>();
	
	public AnimalType() {}
	
	public AnimalType(String animalType) {
		this.animalType = animalType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	
	
}
