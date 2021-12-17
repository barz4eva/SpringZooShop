package zoo.spring.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.spring.project.entities.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findUserByUsername(String username);
}
