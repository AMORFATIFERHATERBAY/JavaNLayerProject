package codingJava.northwind.business.abstracts;

import codingJava.northwind.core.entities.User;
import codingJava.northwind.core.utilities.results.DataResult;
import codingJava.northwind.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	
	DataResult<User> findByEmail(String email);
}
