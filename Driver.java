import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.Map; //place with imports
import java.util.Collections; //place with imports
import java.util.HashMap;
import com.opencsv.CSVReader;

public class Driver {

    private static String file = "C://Users//gabri//Downloads//FinalProject//cs1111finalproject//testdata.csv";
    private static ArrayList<Integer> test = new ArrayList();

    public static void main(String args[]) {

        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 0;
            ArrayList<Sentence> objects = new ArrayList();

            while ((line = read.readLine()) != null) {
                Sentence addVal = Sentence.convertLine(line);
                System.out.println(addVal);
                objects.add(count, addVal);
                count++;
            }
            // System.out.println(objects);
        } catch (IOException exception) {
            System.out.println("File not found");
        }
    }
}
