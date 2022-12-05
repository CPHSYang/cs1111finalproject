import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.Map; //place with imports
import java.util.Collections; //place with imports
import java.util.HashMap;

public class Driver {

    public static ArrayList<Sentence> objects = new ArrayList();
    private static String file = "C://Users//gabri//Downloads//FinalProject//cs1111finalproject//testdata.csv";

    public static void main(String args[]) {

        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = read.readLine()) != null) {
                objects.add(Sentence.convertLine(line));
            }
        } catch (IOException exception) {
            System.out.println("File not found");
        }

        System.out.println(objects);

        /*
         * HashMap<String, Integer> YOUR_HASH_MAP = Sentence.printTopWords(objects);
         * // Copied cost - please check before done
         * Map.Entry<String, Integer> maxEntry = null;
         * 
         * for (Map.Entry<String, Integer> entry : YOUR_HASH_MAP.entrySet())
         * if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
         * maxEntry = entry;
         * int maxValueLen = maxEntry.getValue().toString().length();
         * ArrayList<String> results = new ArrayList<String>();
         * for (Map.Entry set : YOUR_HASH_MAP.entrySet()) {
         * String value = set.getValue().toString();
         * while (value.length() < maxValueLen)
         * value = " " + value;
         * results.add(value + " of " + set.getKey());
         * }
         * Collections.sort(results);
         * Collections.reverse(results);
         * for (int i = 0; i < results.size() && i < 100; i++)
         * System.out.println(results.get(i));
         * System.out.println(results);
         */
    }
}
