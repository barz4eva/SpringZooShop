package zoo.spring.project.repositories;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import zoo.spring.project.entities.Animal;
import zoo.spring.project.entities.AnimalType;
import zoo.spring.project.entities.Breed;

@Repository("animalRepository")
public interface AnimalRepository extends JpaRepository<Animal, Integer>{
	
	public Animal findByType(AnimalType type);
	public Animal findByBreed(Breed breed);
	public Animal findByTypeAndBreed(AnimalType type, Breed breed);
	public Animal deleteByType(AnimalType type);
	
	
	
	

	@Override
	List<Animal> findAll();
}
