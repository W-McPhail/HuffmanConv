//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class HuffmanTree {
    HuffmanNode root;

    public HuffmanTree(HuffmanNode huff) {
        this.root = huff;
    }

    public void printLegend() {
        this.printLegend(this.root, "");
    }

    void printLegend(HuffmanNode huff, String s) {
        if (huff.letter.length() > 1) {
            this.printLegend(huff.left, s + "0");
            this.printLegend(huff.right, s + "1");
        } else {
            System.out.println(huff.letter + "=" + s);
        }

    }

    static BinaryHeap legendToHeap(String legend) {
        String[] split = legend.split(" ");
        BinaryHeap outputHeap = new BinaryHeap();

        for(int i = 0; i < split.length; i += 2) {
            String letter = split[i];
            double freq = Double.parseDouble(split[i + 1]);
            HuffmanNode newNode = new HuffmanNode(letter, freq);
            outputHeap.insert(newNode);
        }

        return outputHeap;
    }

    static HuffmanTree createFromHeap(BinaryHeap b) {
        while(b.getSize() > 1) {
            HuffmanNode min1 = (HuffmanNode)b.deleteMin();
            HuffmanNode min2 = (HuffmanNode)b.deleteMin();
            HuffmanNode newNodeToAdd = new HuffmanNode(min1, min2);
            b.insert(newNodeToAdd);
        }

        return new HuffmanTree((HuffmanNode)b.findMin());
    }
}
