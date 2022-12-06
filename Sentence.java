import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class Sentence {

    private static String text;
    private static String author;
    private static String timestamp;

    private static String[] stopwords = { "a", "about", "above", "after", "again", "against", "all", "am", "an", "and",
            "any", "are",
            "aren't", "as", "at", "be", "because", "been", "before", "being", "below", "between", "both", "but", "by",
            "can't", "cannot", "could", "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down",
            "during", "each", "few", "for", "from", "further", "had", "hadn't", "has", "hasn't", "have", "haven't",
            "having", "he", "he'd", "he'll", "he's", "her", "here", "here's", "hers", "herself", "him", "himself",
            "his", "how", "how's", "i", "i'd", "i'll", "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's",
            "its", "itself", "let's", "me", "more", "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off",
            "on", "once", "only", "or", "other", "ought", "our", "ours ourselves", "out", "over", "own", "same",
            "shan't", "she", "she'd", "she'll", "she's", "should", "shouldn't", "so", "some", "such", "than", "that",
            "that's", "the", "their", "theirs", "them", "themselves", "then", "there", "there's", "these", "they",
            "they'd", "they'll", "they're", "they've", "this", "those", "through", "to", "too", "under", "until", "up",
            "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were", "weren't", "what", "what's",
            "when", "when's", "where", "where's", "which", "while", "who", "who's", "whom", "why", "why's", "with",
            "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your", "yours", "yourself",
            "yourselves" }; // from https://www.ranks.nl/stopwords

    public Sentence(String text, String author, String timestamp) {
        this.text = text;
        this.author = author;
        this.timestamp = timestamp;
    }

    public Sentence() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String toString() {
        return "{author:" + author + ", sentence:" + text + ", timestamp:" + timestamp + "}";
    }

    public static Sentence convertLine(String line) {
        String[] values = line.split("\",\"");
        author = values[4].replaceAll("\"", "");
        timestamp = values[2].replaceAll("\"", "");
        String[] timecodes = timestamp.split(" ");
        timestamp = timecodes[1] + " " + timecodes[2] + " " + timecodes[5];
        text = values[5].toLowerCase().replaceAll("\"", "").replaceAll("\\.", "")
                .replaceAll(",", "").replaceAll("-", "").replaceAll("!", "")
                .replaceAll(":", "").replaceAll("\\?", "").replaceAll(";", "").replaceAll("&", "");
        Sentence convert = new Sentence(text, author, timestamp);
        return convert;
    }

    public static ArrayList<String> splitSentence() {
        // Create new array list with split words passed in
        ArrayList<String> splits = new ArrayList(Arrays.asList(text.split(" ")));
        // Check each word in splits array for a stop word, if there, delete
        for (int i = 0; i < splits.size(); i++) {
            // Check word against all words in stop words
            for (int k = 0; k < stopwords.length; k++) {
                // If string at index is a stop word, remove that word
                if (splits.get(i).equals(stopwords[k])) {
                    splits.remove(i);
                    System.out.println(stopwords[k]);
                }
            }
        }
        return splits;
    }

    public static HashMap<String, Integer> printTopWords(ArrayList<Sentence> sentenceObj) {
        // create Hashmap object map size of the array of words in message
        HashMap<String, Integer> map = new HashMap();
        // For each instance of a word in array, add to count
        for (int k = 0; k < sentenceObj.size(); k++) {
            // System.out.println(sentenceObj.get(k).splitSentence());
            String record;
            ArrayList<String> splitRet = sentenceObj.get(k).splitSentence();

            for (int i = 0; i < splitRet.size(); i++) {
                int counter = 0;
                record = splitRet.get(i);
                for (int j = 0; j < splitRet.size(); j++) {
                    if (record == splitRet.get(j)) {
                        counter++;
                    }
                }
                // Add map pair for each word in the returned array from split sentence
                map.put(splitRet.get(i), counter);

            }
        }
        System.out.println(sentenceObj.size());
        return map;

    }
}
