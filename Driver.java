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

    public static void main(String args[]) {
        ArrayList<Sentence> objects = new ArrayList();

        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = read.readLine()) != null) {
                objects.add(Sentence.convertLine(line));
            }
            System.out.println(objects.size());
        } catch (IOException exception) {
            System.out.println("File not found");
        }

        HashMap<String, Integer> YOUR_HASH_MAP = Sentence.printTopWords(objects);

        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : YOUR_HASH_MAP.entrySet())
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                maxEntry = entry;
        int maxValueLen = maxEntry.getValue().toString().length();
        ArrayList<String> results = new ArrayList<String>();
        for (Map.Entry set : YOUR_HASH_MAP.entrySet()) {
            String value = set.getValue().toString();
            while (value.length() < maxValueLen)
                value = " " + value;
            results.add(value + " of " + set.getKey());
        }
        Collections.sort(results);
        Collections.reverse(results);
        for (int i = 0; i < results.size() && i < 100; i++)
            System.out.println(results.get(i));

    }
}
