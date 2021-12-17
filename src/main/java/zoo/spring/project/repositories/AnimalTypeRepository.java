package zoo.spring.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.spring.project.entities.AnimalType;
import zoo.spring.project.entities.Breed;

@Repository("animalTypeRepository")
public interface AnimalTypeRepository extends JpaRepository<AnimalType, Long> {
	
	
	AnimalType findByAnimalType(String animalType);
	
	
	@Override
	List<AnimalType> findAll();

}
