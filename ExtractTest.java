public class ExtractTest {

    public static void main(String args[]) {

        String line = "\"4\",\"3\",\"Mon May 11 03:17:40 UTC 2009\",\"kindle2\",\"tpryan\",\"@stellargirl I loooooooovvvvvveee my Kindle2. Not that the DX is cool, but the 2 is fantastic in its own right.\"";

        // Test Case 1
        String expectedMessage = "@stellargirl I loooooooovvvvvveee my Kindle2 Not that the DX is cool but the 2 is fantastic in its own right";

        if (expectedMessage.equals(Sentence.convertLine(line).getText())) {
            System.out.println("Test one true");
        } else {
            System.out.println("Test one false");
        }

        // Test Case 2
        String expectedTime = "May 11 2009";
        if (expectedTime.equals(Sentence.convertLine(line).getTimestamp())) {
            System.out.println("Test two true");
        } else {
            System.out.println("Test two false");
        }
    }

}
