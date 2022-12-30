package tacos.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tacos.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT a FROM User a WHERE a.username = :username")
	User findByUserName(@Param("username") String username);


}
