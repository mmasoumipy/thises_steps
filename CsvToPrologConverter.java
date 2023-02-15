import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvToPrologConverter {

    public static void main(String[] args) {

        // CSV file path
        String csvFilePath = "output.csv";

        // Prolog file path
        String prologFilePath = "output.pl";

        // Open the CSV file for reading
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

            // Open the Prolog file for writing
            try (FileWriter fw = new FileWriter(prologFilePath)) {

                // Read each line of the CSV file
                String line;
                while ((line = br.readLine()) != null) {

                    // Split the line into fields
                    String[] fields = line.split(",");

                    // Convert the fields to Prolog format
                    String rule = fields[0] + "(" + fields[1] + ", " + fields[2] + ").\n";

                    // Write the Prolog rule to the file
                    fw.write(rule);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
