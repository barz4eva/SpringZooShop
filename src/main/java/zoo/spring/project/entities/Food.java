package zoo.spring.project.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "food")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "food_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "animal_type")
	private AnimalType type;
	
	@Column(name = "brand")
	private String brand;

}
