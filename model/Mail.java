


public class Mail {

	private distance mailDistance;
	private destination mailDestination;
	private String sImage;
	
	public Mail(distance mailDistance, destination mailDestination) {
		this.mailDistance = mailDistance;
		this.mailDestination = mailDestination;
		
	}
	
	public distance getMailDistance() {
		return mailDistance;
	}
	
	public void setMailDistance(distance mailDistance) {
		this.mailDistance = mailDistance;
	}
	
	public destination getMailDestination() {
		return mailDestination;
	}
	
	public void setMailDestination(destination mailDestination) {
		this.mailDestination = mailDestination;
	}
	
	
}

