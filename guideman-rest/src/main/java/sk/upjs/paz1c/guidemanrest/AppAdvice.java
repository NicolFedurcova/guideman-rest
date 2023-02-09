package sk.upjs.paz1c.guidemanrest;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import sk.upjs.paz1c.guideman.storage.EntityNotFoundException;
import sk.upjs.paz1c.guideman.storage.NegativeNumberException;

@ControllerAdvice
public class AppAdvice {
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ResponseBody
	public AppErrorHandler handleMethodArgumentTypeMismatchException (MethodArgumentTypeMismatchException e ) {
		return new AppErrorHandler(HttpStatus.NOT_ACCEPTABLE.value(), "Method argument has not the expected type. Change data type of the argument");
	}
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public AppErrorHandler handleEntityNotFoundException(EntityNotFoundException e) {
		return new AppErrorHandler(HttpStatus.BAD_REQUEST.value(), "Object with method argument was not found");
		}
	
	@ExceptionHandler(NegativeNumberException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ResponseBody
	public AppErrorHandler handleNegativeNumberException(NegativeNumberException e) {
		return new AppErrorHandler(HttpStatus.NOT_ACCEPTABLE.value(), "Method argment cannot be a negative number");
		}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public AppErrorHandler handleNoSuchElementException(NoSuchElementException e) {
		return new AppErrorHandler(HttpStatus.BAD_REQUEST.value(), "Object with method argument was not found");
	}
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public AppErrorHandler handleNullPointerException(NullPointerException e) {
		return new AppErrorHandler(HttpStatus.BAD_REQUEST.value(), "argument cannot be null");
	}

}
