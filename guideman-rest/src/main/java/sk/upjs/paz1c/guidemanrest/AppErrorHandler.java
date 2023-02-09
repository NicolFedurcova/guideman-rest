package sk.upjs.paz1c.guidemanrest;

public class AppErrorHandler {
	
	private int status;
	private String errorMessage;
	
	
	public AppErrorHandler(int status, String errorMessage) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public int getStatus() {
		return status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}	

}
