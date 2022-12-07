import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Book {

    private String[] allWords;
    private int newWordIndex;
    private String content;
    private String filePath;
    private TextScaper textScaper;


    public Book(TextScaper textScaper, String filepath) {
        this.newWordIndex = 0;
        this.textScaper = textScaper;
        this.filePath = filepath;
        try {
            PDFParser pdfParser = new PDFParser(filepath);
            this.content = pdfParser.pdfToString();
        } catch (IOException exception) {
            System.out.println("There was an exception");
        } catch (TikaException | SAXException e) {
            e.printStackTrace();
        }
        this.allWords = this.textScaper.analyseWords(this.content);
    }

    //todo: update newWordCounter
    public void printNewWords() {
        if (this.newWordIndex == this.allWords.length) {
            System.out.println("There are no new words");
            return;
        }
        boolean hasTenMoreWords = (this.allWords.length-this.newWordIndex) >= 10;
        if (hasTenMoreWords) {
            for (int i = this.newWordIndex; i < newWordIndex+10; i++) {
                System.out.println(this.allWords[i]);
            }
        } else {
            for (int i = this.newWordIndex; i <= this.allWords.length-1; i++) {
                System.out.println(this.allWords[i]);
            }
        }
    }

    public int getNewWordIndex() {
        return newWordIndex;
    }

    public TextScaper getTextScaper() {
        return textScaper;
    }

    public String getContent() {
        return content;
    }

    public String getFilePath() {
        return filePath;
    }

    public String[] getAllWords() {
        return allWords;
    }

}
