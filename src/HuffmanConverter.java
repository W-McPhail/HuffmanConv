//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HuffmanConverter {
    public static final int number_of_characters = 256;
    private int[] count = new int[256];
    private String[] code = new String[256];
    private int unique_chars;
    private String contents;

    public HuffmanConverter(String input) {
        this.contents = input;
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
            } catch (IOException var4) {
                var4.printStackTrace();
            }

        }
    }

    public void recordFrequencies() {
        HashMap<Character, Integer> map = new HashMap();
        String s = this.contents;

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            Integer val = (Integer)map.get(c);
            if (val != null) {
                map.put(c, new Integer(val + 1));
            } else {
                map.put(c, 1);
            }
        }

        System.out.println(map);
        String[] legend = new String[map.size() * 2 + 1];
        int c = 0;

        for(Iterator it = map.entrySet().iterator(); it.hasNext(); c += 2) {
            Entry<Character, Integer> pair = (Entry)it.next();
            legend[c] = Character.toString((Character)pair.getKey());
            legend[c++] = Character.toString((Integer)pair.getValue());
        }

        String[] var13 = legend;
        int var7 = legend.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            String x = var13[var8];
            System.out.println(x);
        }

    }

    public void frequenciesToTree() {
    }
}
