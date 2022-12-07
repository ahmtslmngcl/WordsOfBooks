import java.util.Arrays;
import java.util.List;

public class TextScaper {

    public String[] analyseWords(String text) {
        return Arrays.stream(text.split(" ")).distinct().toArray(String[]::new);
    }

}
