package zoo.spring.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.spring.project.entities.AnimalType;
import zoo.spring.project.entities.Food;

@Repository("foodRepository")
public interface FoodRepository extends JpaRepository<Food, Long>{
	Food findByType(AnimalType type);
	Food findByBrand(String brand);

}
