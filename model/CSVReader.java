
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReader {
	
	public ArrayList<location> readFile(){
	String csvFile = "C:\\Users\\Enoch\\Desktop\\DLSU\\DASALGO\\DASALGO\\Sample\\src\\Map.csv";
    String line = "";
    String cvsSplitBy = ",";
    
    ArrayList<location> locationList = new ArrayList<location>();

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

        while ((line = br.readLine()) != null) {
        	location l = new location();
            // use comma as separator
            String[] loc = line.split(cvsSplitBy);
            l.setsPostNames(loc[0]);
            l.setsLocation(loc[1]);
            l.setsDestination(loc[2]);
            l.setsDistance(loc[3]);
            System.out.println("[Post Office = "+ loc[0] + "] [Location = " + loc[1] + "] [Destination = " + loc[2] + "] [Distance(km) = "+ loc[3]+"]");
            locationList.add(l);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    return locationList;
}
}
