import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class BookReader {
    
    public static LinkedList<String> readBook(String fileName) throws IOException {
        LinkedList<String> words = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] lineWords = line.split("\\s+");
            words.addAll(Arrays.asList(lineWords));
        }
        reader.close();
        return words;
    }
    
}
