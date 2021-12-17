package zoo.spring.project.controller;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.var;
import zoo.spring.project.entities.Animal;
import zoo.spring.project.entities.AnimalType;
import zoo.spring.project.entities.Breed;
import zoo.spring.project.entities.Food;
import zoo.spring.project.entities.Toys;
import zoo.spring.project.repositories.AnimalRepository;
import zoo.spring.project.repositories.AnimalTypeRepository;
import zoo.spring.project.repositories.BreedRepository;
import zoo.spring.project.repositories.FoodRepository;
import zoo.spring.project.repositories.ToysRepository;


@RestController
public class HomeController {
    
	private final AnimalRepository animalRepository;
	private final AnimalTypeRepository animalTypeRepository;
	private final FoodRepository foodRepository;
	private final ToysRepository toysRepository;
	private final BreedRepository breedRepository;
	
	
	
	
	@Autowired
	public HomeController(@Qualifier("animalRepository")AnimalRepository animalRepository,
			@Qualifier("foodRepository")FoodRepository foodRepository,
			@Qualifier("toysRepository")ToysRepository toysRepository,
			@Qualifier("animalTypeRepository")AnimalTypeRepository animalTypeRepository,
			@Qualifier("breedRepository")BreedRepository breedRepository){
    
				this.animalRepository = animalRepository;
				this.foodRepository = foodRepository;
				this.toysRepository = toysRepository;
				this.animalTypeRepository = animalTypeRepository;
				this.breedRepository = breedRepository;
				
				
			}
	
	
//	)
	
	//Create
	@PostMapping(path = "/animalAdd")
	public Animal addAnimal(@RequestParam(value = "color")String color,
			@RequestParam(value = "animalType")String animalType,
	        @RequestParam(value = "breed")String breed)
			 {
		
		AnimalType type = animalTypeRepository.findByAnimalType(animalType);
		Breed bre = breedRepository.findByBreed(breed);
		
		Animal animal = new Animal(color, type, bre);
		return animalRepository.save(animal);
	
	}
	
	
	
	@PostMapping(path = "/animalTypeAdd")
	public AnimalType addAnimalType(@RequestParam(value = "animalType")String animalType)
			 {
		
		AnimalType type = new AnimalType(animalType);
		return animalTypeRepository.save(type);
	
	}
	
	@PostMapping("/breedAdd")
	public Breed addBreed(@RequestParam(value = "breed")String breed) {
		Breed bre = new Breed(breed);
		return breedRepository.save(bre);
	}
	
	
	
	
	//Read
	@GetMapping(path = "/allAnimals")
	ResponseEntity<List<Animal>> allAnimals(){
		List<Animal> animal = animalRepository.findAll();
		return new ResponseEntity<>(animal, HttpStatus.OK);
	}
	
	@GetMapping(path = "/allBreeds")
	ResponseEntity<List<Breed>> allBreeds(){
		List<Breed> breeds = breedRepository.findAll();
		return new ResponseEntity<>(breeds, HttpStatus.OK);
	}
	
	@GetMapping(path = "/allAnimalTypes")
	ResponseEntity<List<AnimalType>> allAnimalTypes(){
		List<AnimalType> animalTypes = animalTypeRepository.findAll();
		return new ResponseEntity<>(animalTypes, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/filterByAnimalType")
	ResponseEntity<List<Animal>> getByColor(@RequestParam(value = "color")String animalType) {
		  AnimalType type = animalTypeRepository.findByAnimalType(animalType);
          Animal animal = animalRepository.findByType(type);
          
          List<Animal> ani = new ArrayList<>();
          ani.add(animal);
          
         return new ResponseEntity<>(ani, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/filterByTypeAndBreed")
	ResponseEntity<List<Animal>> getByTypeAndBreed(@RequestParam(value = "animalType")String animalType,
			@RequestParam(value = "breed")String breed) {
		  AnimalType type = animalTypeRepository.findByAnimalType(animalType);
		  Breed bre = breedRepository.findByBreed(breed);
		  
          Animal animal = animalRepository.findByTypeAndBreed(type, bre);
          
          List<Animal> ani = new ArrayList<>();
          ani.add(animal);
          
         return new ResponseEntity<>(ani, HttpStatus.OK);
		
	}
	
	//Delete
    @DeleteMapping(path = "/deleteByType")
    @Transactional
    public  void deleteByType(@RequestParam(value = "animalType")String animalType) {
    	AnimalType type = animalTypeRepository.findByAnimalType(animalType);
    	Animal animal = animalRepository.findByType(type);
    	
    	animalRepository.deleteById(animal.getId());
    	
    	

    }
    
	

			
			
	

}
