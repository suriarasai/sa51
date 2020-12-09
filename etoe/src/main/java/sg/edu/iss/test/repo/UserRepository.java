package sg.edu.iss.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.test.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    public User findUserByUserName(String un);
    
}
