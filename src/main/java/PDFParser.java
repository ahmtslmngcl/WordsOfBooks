import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class PDFParser {

    private String filename;
    private File file;
    private FileInputStream fileInputStream;
    private Metadata metadata;

    private org.apache.tika.parser.pdf.PDFParser pdfParser;
    private ParseContext context;
    private BodyContentHandler contentHandler;

    public PDFParser(String filename) throws IOException {
        this.filename = filename;
        this.file = new File(filename);
        this.fileInputStream = new FileInputStream(this.file);
        this.metadata = new Metadata();
        this.contentHandler = new BodyContentHandler();
        this.pdfParser = new org.apache.tika.parser.pdf.PDFParser();
        this.context = new ParseContext();
        if (this.file.canWrite()) System.out.println("file can be written");
    }

    String pdfToString() throws TikaException, IOException, SAXException {
        pdfParser.parse(this.fileInputStream, this.contentHandler, this.metadata, this.context);
        return contentHandler.toString();
    }

    /*
    public static void main(String[] args) throws IOException, TikaException, SAXException {
        // Platziere pdf das extrahiert werden soll in pdfFiles.
        // Gebe als filename den absolut-Pfad an.
        // Bsp. für parsen von discord ausarbeitung:
        //String filename = "src/main/java/pdfFiles/[pdffilename].pdf";
        String filename = "src/main/java/pdfFiles/CV-TumAI.pdf";
        PDFParser pdfParser = new PDFParser(filename);
        System.out.println(pdfParser.pdfToString());
    }
    */

}
