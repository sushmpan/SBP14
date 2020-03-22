package com.training.bean;

public class ApartmentBean {
	private String yourName;
	private String yourEmail;
	private String Subject;
	private String Message;
	
	public ApartmentBean() {
	}

	public ApartmentBean(String yourName, String yourEmail, String Subject,String Message) {
		super();
		this.yourName = yourName;
		this.yourEmail = yourEmail;
		this.Subject = Subject;
		this.Message = Message;
		
	}

	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	public String getYourEmail() {
		return yourEmail;
	}

	public void setYourEmail(String yourEmail) {
		this.yourEmail = yourEmail;
	}
    
	public String getSubject() {
		return Subject ;
	}

	public void setSubject(String Subject) {
		this.Subject = Subject;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		this.Message = message;
	}

	@Override
	public String toString() {
		return "ApartmentBean [yourName=" + yourName +","
				+ "            yourEmail=" + yourEmail+"," 
				+ "            Subject ="  + Subject +","
				+ "            Message=" +   Message +"]";
	}

}
