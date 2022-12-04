import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class Driver {

    public static ArrayList<Sentence> objects = new ArrayList();
    private static String file = "downloads/finalproject/testdata.csv";

    public static void main(String args[]) {

        // https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
        List<List<String>> records = new ArrayList<>();
        List<List<String>> author = new ArrayList<>();
        List<List<String>> timestamp = new ArrayList<>();
        List<List<String>> message = new ArrayList<>();

        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = read.readLine()) != null) {
                objects.add(Sentence.convertLine(line));
            }
        } catch (IOException exception) {
            System.out.println("File not found");
        }

        System.out.println(objects);

    }
}
