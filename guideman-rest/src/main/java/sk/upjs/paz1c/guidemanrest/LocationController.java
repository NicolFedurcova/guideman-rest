package sk.upjs.paz1c.guidemanrest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sk.upjs.paz1c.guideman.storage.DaoFactory;
import sk.upjs.paz1c.guideman.storage.Location;
import sk.upjs.paz1c.guideman.storage.LocationDao;


@RestController 
@CrossOrigin
public class LocationController {
	
	private LocationDao locationDao = DaoFactory.INSTANCE.getLocationDao();
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/locations", method = RequestMethod.GET) 
	public List<Location> getAll() {
		return locationDao.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/locations/{countryName}", method = RequestMethod.GET)
	public List<Location> getAllByCountry(@PathVariable String countryName) {
		return locationDao.getAllByCountry(countryName);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/locations/id/{locationId}", method = RequestMethod.GET)
	public Location getById(@PathVariable long locationId) {
		return locationDao.getById(locationId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/locations", method = RequestMethod.POST)
	public Location save(@RequestBody Location location) { 
		return locationDao.save(location);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/locations/delete/{locationId}", method = RequestMethod.DELETE)
	public boolean  delete(@PathVariable long locationId) {		
		return locationDao.delete(locationId);
	}


}