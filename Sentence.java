import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class Sentence {

    private static String text;
    private static String author;
    private static String timestamp;

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
        String author = values[4].replaceAll("\"", "");
        String timestamp = values[2].replaceAll("\"", "");
        String[] timecodes = timestamp.split(" ");
        timestamp = timecodes[1] + " " + timecodes[2] + " " + timecodes[5];
        String text = values[5].replaceAll("\"", "").replaceAll("\\.", "")
                .replaceAll(",", "").replaceAll("-", "").replaceAll("!", "")
                .replaceAll(":", "").replaceAll("\\?", "").replaceAll(";", "");
        Sentence convert = new Sentence(text, author, timestamp);
        return convert;
    }
}
