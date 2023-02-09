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
import sk.upjs.paz1c.guideman.storage.Tour;
import sk.upjs.paz1c.guideman.storage.TourDao;

@RestController 
@CrossOrigin
public class TourController {
	
	private TourDao tourDao = DaoFactory.INSTANCE.getTourDao();
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/tours", method = RequestMethod.GET) 
	public List<Tour> getAll() {
		return tourDao.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/tours/location/{locationId}", method = RequestMethod.GET) 
	public List<Tour> getAllToursByLocation(@PathVariable long locationId) {
		return tourDao.getAllToursByLocation(locationId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/tours/guideman/{guidemanId}", method = RequestMethod.GET) 
	public List<Tour> getAllToursByGuideman(@PathVariable long guidemanId) {
		return tourDao.getAllToursByGuideman(guidemanId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/tours/id/{tourId}", method = RequestMethod.GET)
	public Tour getById(@PathVariable long tourId) {
		return tourDao.getById(tourId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/tours", method = RequestMethod.POST)
	public Tour save(@RequestBody Tour tour) { 
		return tourDao.save(tour);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/tours/delete/{tourId}", method = RequestMethod.DELETE)
	public boolean  delete(@PathVariable long tourId) {		
		return tourDao.delete(tourId);
	}

}
