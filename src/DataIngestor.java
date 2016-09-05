import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Data Ingestor that takes a path to a CSV file and returns a hashmap
 * Created by Andy on 9/9/2015.
 */
public class DataIngestor {

    HashMap<String, String> values = new HashMap();
    BufferedReader br = null;
    String line = "";
    String seperator = ",";

    /**
     * Constructor for DataInjestor
     */
    public DataIngestor() {
    }

    /**
     * Method for taking a csv and converting it to a hashmap
     * @param csvPath path the the csv file
     */
    public void Ingest(String csvPath) {
        try {
            br = new BufferedReader(new FileReader(csvPath));
            while ((line = br.readLine()) != null) {
                String[] pasrsed = line.split(seperator);
                if (pasrsed.length != 2) {
                    System.out.println("Expected 2 fields, file is " + pasrsed.length);
                    break;
                }
                values.put(pasrsed[0], pasrsed[1]);
            }
        } catch (FileNotFoundException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace();
        } finally {
            if (br != null) {
                try { br.close();
                } catch (IOException e) { e.printStackTrace();
                }
            }
        }
    }

    public HashMap getValues() {
        return values;
    }
}