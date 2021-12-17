package zoo.spring.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.spring.project.entities.AnimalType;
import zoo.spring.project.entities.Toys;

@Repository("toysRepository")
public interface ToysRepository extends JpaRepository<Toys, Long>{
	Toys findByType(AnimalType type);
	Toys findByToyName(String toyName);
}
