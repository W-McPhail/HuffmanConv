import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;


public class HuffmanConverter {
    public static final int number_of_characters = 256;
    private int[] count;
    private String[] code;
    private int unique_chars;
    private String contents;
    private String legend = "";
    private HuffmanTree huffmanTree;
    private BinaryHeap b;

    public HuffmanConverter(String input) {
        this.contents = input;
        this.count = new int[number_of_characters];
        this.code = new String[number_of_characters];
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide only 1 arg");
        } else {
            try {
                byte[] bytes = Files.readAllBytes((new File(args[0])).toPath());
                String input = new String(bytes);
                HuffmanConverter converter = new HuffmanConverter(input);
                converter.recordFrequencies();
            } catch (IOException var404) {
                var404.printStackTrace();
            }

        }
    }

    public void recordFrequencies() {

        for (int i = 0; i < contents.length(); i++) {
            int intChar = (int) contents.charAt(i);
            if (count[intChar] == 0) {
                count[intChar] = 1;
            } else {
                count[intChar] = count[intChar] + 1;
            }
        }

        for (int i = 0; i < count.length; i++) {
            char chari = (char)i;
            int freq = count[i];
            if (freq != 0) {
                legend = legend + " " + chari + " " + freq;
            }
        }
        System.out.println(legend);
    }

    public void frequenciesToTree() {

    }
}


