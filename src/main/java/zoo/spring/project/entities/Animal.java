package zoo.spring.project.entities;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "animal")
public class Animal {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "animal_id")
	private int id;
	
	@Column(name = "color")
	private String color;
	
	@ManyToOne
	@JoinColumn(name = "animal_type")
	private AnimalType type;
	
	@ManyToOne
	@JoinColumn(name = "breed")
	private Breed breed;
	
	public Animal() {}
	
	public Animal(String color, AnimalType type, Breed breed) {
		this.color = color;
		this.type = type;
		this.breed = breed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public AnimalType getType() {
		return type;
	}

	public void setType(AnimalType type) {
		this.type = type;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}
	
	
}
