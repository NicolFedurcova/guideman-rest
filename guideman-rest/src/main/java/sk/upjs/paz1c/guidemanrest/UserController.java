package sk.upjs.paz1c.guidemanrest;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import sk.upjs.paz1c.guideman.storage.DaoFactory;
import sk.upjs.paz1c.guideman.storage.Location;
import sk.upjs.paz1c.guideman.storage.User;
import sk.upjs.paz1c.guideman.storage.UserDao;



@RestController 
@CrossOrigin
public class UserController {
	
	UserDao userDao = DaoFactory.INSTANCE.getUserDao();
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/users", method = RequestMethod.GET) 
	public List<User> getAll() {
		return userDao.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/users/guidemans", method = RequestMethod.GET) 
	public List<User> getAllGuidemans() {
		return userDao.getAllGuidemans();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/users/event-tourists/{eventId}", method = RequestMethod.GET) 
	public List<User> getAllTourists(@PathVariable long eventId) {
		return userDao.getAllTourists(eventId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/users/id/{userId}", method = RequestMethod.GET) 
	public User getById(@PathVariable long userId) {
		return userDao.getById(userId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/users/username/{userName}", method = RequestMethod.GET) 
	public User getUserByUsername(@PathVariable String userName) {
		return userDao.getUserByUsername(userName);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/users", method = RequestMethod.POST)
	public User save(@RequestBody User user) { 
		return userDao.save(user);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/users/delete/{userId}", method = RequestMethod.DELETE)
	public boolean  delete(@PathVariable long userId) {		
		return userDao.delete(userId);
	}


}