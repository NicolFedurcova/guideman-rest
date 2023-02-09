package sk.upjs.paz1c.guidemanrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import sk.upjs.paz1c.guideman.storage.DaoFactory;
import sk.upjs.paz1c.guideman.storage.Tour;
import sk.upjs.paz1c.guideman.storage.TourDao;

@SpringBootApplication
public class App {
	//https://stackoverflow.com/questions/47883374/register-modules-in-object-mapper-globally
	@Autowired
	  void configureObjectMapper(final ObjectMapper mapper) {
	   mapper.registerModule(new JavaTimeModule());
	   mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	  }
	

	public static void main(String[] args) {	
		SpringApplication.run(App.class, args);	
	}

}