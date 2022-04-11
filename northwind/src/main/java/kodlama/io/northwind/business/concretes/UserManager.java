package kodlama.io.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwind.business.abstracts.UserService;
import kodlama.io.northwind.core.dataAccsess.UserDao;
import kodlama.io.northwind.core.entities.User;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.core.utilities.results.SuccsessDataResult;
import kodlama.io.northwind.core.utilities.results.SuccsessResult;
@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccsessResult("Kullanıcı eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		
		return new SuccsessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı bulundu");
	}

}
