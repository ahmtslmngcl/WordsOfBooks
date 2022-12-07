import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, TikaException, SAXException {

        TextScaper textScaper = new TextScaper();
        Book randomBook = new Book(textScaper, "src/main/java/pdfFiles/[filename].pdf");
        Arrays.stream(randomBook.getAllWords()).forEach(System.out::println);

    }

}
