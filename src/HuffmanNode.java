//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class HuffmanNode implements Comparable {
    public String letter;
    public Double frequency;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(String letter, Double frequency) {
        this.letter = letter;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(HuffmanNode left, HuffmanNode right) {
        this.letter = left.letter + right.letter;
        this.frequency = left.frequency + right.frequency;
        this.left = left;
        this.right = right;
    }

    public int compareTo(Object O) {
        HuffmanNode huff = (HuffmanNode)O;
        return this.frequency.compareTo(huff.frequency);
    }

    public String toString() {
        String var10000 = this.letter;
        return "<" + var10000 + ", " + this.frequency.toString() + ">";
    }
}
