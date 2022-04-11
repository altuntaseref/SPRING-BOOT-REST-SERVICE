package kodlama.io.northwind.core.dataAccsess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwind.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String Email);
	
}


