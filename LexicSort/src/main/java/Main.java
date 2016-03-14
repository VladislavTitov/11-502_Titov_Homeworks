import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TextReaderWriter trw = new TextReaderWriter();
        trw.readWord();
        trw.sorter.sortWords();
        trw.show();
        trw.writeWord();
    }
}
