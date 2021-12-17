package zoo.spring.project.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "toys")
public class Toys {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "toy_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "animal_type")
	private AnimalType type;
	
	@Column(name = "toy_name")
	private String toyName;

}
