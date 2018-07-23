
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	
	public static void main(String args[]) {
	String csvFile = "C:\\Users\\Micah\\Desktop\\Micah\\3rd Term 2017-2018\\DASALGO\\MP1\\Map.csv";
    String line = "";
    String cvsSplitBy = ",";

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

        while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] loc = line.split(cvsSplitBy);

            System.out.println("[Post Office = "+ loc[0] + "] [Location = " + loc[1] + "] [Destination = " + loc[2] + "] [Distance(km) = "+ loc[3]+"]");

        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
