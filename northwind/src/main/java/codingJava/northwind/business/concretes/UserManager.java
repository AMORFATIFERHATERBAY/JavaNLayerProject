package codingJava.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import codingJava.northwind.business.abstracts.UserService;
import codingJava.northwind.core.dataAccess.UserDao;
import codingJava.northwind.core.entities.User;
import codingJava.northwind.core.utilities.results.DataResult;
import codingJava.northwind.core.utilities.results.Result;
import codingJava.northwind.core.utilities.results.SuccessDataResult;
import codingJava.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(@RequestBody User user) {
		
		this.userDao.save(user);
		return new SuccessResult("User is added") ;
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		
		return new SuccessDataResult<User>(
				this.userDao.findByEmail(email),"User is found");
	}

}
