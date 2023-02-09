package sk.upjs.paz1c.guidemanrest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sk.upjs.paz1c.guideman.storage.DaoFactory;
import sk.upjs.paz1c.guideman.storage.Event;
import sk.upjs.paz1c.guideman.storage.EventDao;


@RestController 
@CrossOrigin
public class EventController {
	
	private EventDao eventDao = DaoFactory.INSTANCE.getEventDao();
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/events", method = RequestMethod.GET) 
	public List<Event> getAll() {
		return eventDao.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/events/id/{eventId}", method = RequestMethod.GET)
	public Event getById(@PathVariable long eventId) {
		return eventDao.getById(eventId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/events/tourId/{tourId}", method = RequestMethod.GET)
	public List<Event> getAllByTour(@PathVariable long tourId) {
		return eventDao.getAllByTour(tourId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/events/country/{country}", method = RequestMethod.GET)
	public List<Event> getAllEventsByCountry(@PathVariable String country) {
		return eventDao.getAllEventsByCountry(country);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/events", method = RequestMethod.POST)
	public Event save(@RequestBody Event event) { 
		return eventDao.save(event);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/events/delete/{eventId}", method = RequestMethod.DELETE)
	public boolean  delete(@PathVariable long eventId) {		
		return eventDao.delete(eventId);
	}

}
