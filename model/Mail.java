package model;

public class Mail {

	private String mailLocation;
	private String mailDestination;
	private float mailDistance;
	private int mailpriority;
	
	
	
	public int getMailPriority() {
		return mailpriority;
	}
	public void setMailPriority(int priority) {
		this.mailpriority = priority;
	}
	public String getMailLocation() {
		return mailLocation;
	}
	public void setMailLocation(String mailLocation) {
		this.mailLocation = mailLocation;
	}
	public String getMailDestination() {
		return mailDestination;
	}
	public void setMailDestination(String mailDestination) {
		this.mailDestination = mailDestination;
	}
	public float getMailDistance() {
		return mailDistance;
	}
	public void setMailDistance(float mailDistance) {
		this.mailDistance = mailDistance;
	}
	
	
	
}
