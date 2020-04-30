import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.StringJoiner;


public class HuffmanConverter {
    public static final int number_of_characters = 256;
    private int[] count;
    private String[] code;
    private String contents;
    private String legend = "";
    private HuffmanTree huffmanTree;
    private BinaryHeap bHeap;

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
                converter.frequenciesToTree();
                String coded = converter.encodeMessage();
                System.out.println(coded);
                System.out.println(converter.decodeMessage(coded));
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
        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < count.length; i++) {
            char chari = (char) i;
            int freq = count[i];
            if (freq != 0) {
                joiner.add(chari + " " + freq);
            }
        }
        legend = joiner.toString();
        //System.out.println(legend);
    }

    public void frequenciesToTree() {
        bHeap = HuffmanTree.legendToHeap(legend);
        bHeap.printHeap();
        huffmanTree = HuffmanTree.createFromHeap(bHeap);
        huffmanTree.printLegend();
        treeToCode();
        System.out.println(Arrays.toString(code));
    }

    public void treeToCode(){
        for (int i = 0; i < number_of_characters; i++){
            code[i] = "";
        }
        treeToCode(huffmanTree.root, "");
    }

    private void treeToCode(HuffmanNode t, String s){
        if (t.letter.length() > 1) {
            treeToCode(t.left, s + "0");
            treeToCode(t.right, s + "1");
        } else {
            code[(int)t.letter.charAt(0)] = s;
        }
    }

    public String encodeMessage() {
        String coded = "";
        for (int i = 0; i < contents.length(); i++) {
            coded += code[(int) contents.charAt(i)];
        }
        return coded;
    }

    public String decodeMessage(String encodedStr){
        String tempStr = "";
        String outputStr = "";
        for (int i = 0; i < number_of_characters; i++){
            if(code[i] == ""){
                code[i] = "∫ç≈";
            }
        }
        for (int k = 0; k < encodedStr.length(); k++){
            tempStr += encodedStr.charAt(k);
            for (int x = 0; x < number_of_characters; x++){
                if(code[x].equals(tempStr)){
                    outputStr += (char)x;
                    tempStr = "";
                }
                else{
                    outputStr = outputStr;
                }
            }
        }
        return outputStr;
    }
}


