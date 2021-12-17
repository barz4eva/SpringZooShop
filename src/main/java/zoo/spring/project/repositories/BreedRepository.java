package zoo.spring.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.spring.project.entities.Breed;

@Repository("breedRepository")
public interface BreedRepository extends JpaRepository<Breed, Long>{
   
	Breed getById(int id);
	Breed findByBreed(String breed);
	
	@Override
	 List<Breed> findAll();
	 
	

}
