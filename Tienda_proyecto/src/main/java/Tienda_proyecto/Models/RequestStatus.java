package Tienda_proyecto.Models;

public class RequestStatus {

	private Boolean Status;
	private String Message;
	
	
	// CONSTRUCTORS
	public RequestStatus(Boolean status, String message) {
		super();
		Status = status;
		Message = message;
	}

	
	// GETs AND SETs
	public Boolean getStatus() {
		return Status;
	}

	public void setStatus(Boolean status) {
		Status = status;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	
	
	
}
