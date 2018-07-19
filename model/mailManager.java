
import java.util.ArrayList;
import java.util.Scanner;


public class mailManager {
	private ArrayList<postOffice> postOfficeList;
	private ArrayList<location> locationList;
	private ArrayList<destination> destinationList;
	private ArrayList<distance> distanceList;
	private ArrayList<Mail> mailList;
	
	//private Mail mail;
	private mailMan mailman;

	public mailManager() {
		
		initializeComponents();
		startMail();
		
	}
	
	public void initializeComponents() {
		/*** Read from MAP.CSV ***/
		CSVReader csvreader = new CSVReader();
		/*** Read from MAP.CSV ***/
		 
		/*** Initialize Mail ***/
		//mail = new Mail();
		mailman = new mailMan();
		/*** Initialize Mail ***/
		
		/*** Initialize postOffice ***/
		postOfficeList = new ArrayList<postOffice>();
		postOfficeList.add(new postOffice("Manila City"));	
		postOfficeList.add(new postOffice("Quezon City"));
		postOfficeList.add(new postOffice("Makati City"));
		postOfficeList.add(new postOffice("Pasay City"));
		/*** Initialize postOffice ***/
	
	}

	public void startMail() {
		Scanner scan = new Scanner(System.in);
		int postOfficeInput = -999, mailInput = -999;
		boolean isFinished = false; //check if user has chosen a command
		
		
		System.out.println("\nWelcome to the Mail Delivery Simulation");
        /***prints out the post office for the user to choose***/

		for(int i = 0; i < postOfficeList.size(); i++) {
			System.out.println((i+1) + ".) " + postOfficeList.get(i).getsPostOffice());  
		}
        /***prints out the post office for the user to choose***/
		
		while(isFinished == false) {
		
			System.out.println("Please choose you starting point: \n");
			char pOfficeInput = scan.next().charAt(0);
			if(Character.isDigit(pOfficeInput)) {
				StringBuilder sb = new StringBuilder(); // converts to String
                String string = sb.append(pOfficeInput).toString();
                if(Integer.parseInt(string) <= postOfficeList.size() && Integer.parseInt(string) >= 1){
                    postOfficeInput = Integer.parseInt(string);
                    postOfficeInput--; //bc array starts at 0
                    isFinished = true;
                }
                else{
                    System.out.println("Please Choose wisely");
            }
			}
		}
		System.out.println("Current Post Office:  " + postOfficeList.get(postOfficeInput).getsPostOffice());
		//mail.setMailpostOffice(postOfficeList.get(postOfficeInput)); // sets the first mail to the starting point
		mailman.setMailpostOffice(postOfficeList.get(postOfficeInput));

		
		System.out.println("\nHow Many Mails are there to be delivered?");
		mailInput = scan.nextInt();
		
		mailList = new ArrayList<Mail>();
		for(int i = 0; i <= mailInput; i++) {
			// mailList.add(new Mail()); // CREATE NEW INSTANCES OF MAILS FROM CSV FILE
			 
		}
		
		//System.out.println(mailInput); // to check if mails to be delivered is correct
	}

}

