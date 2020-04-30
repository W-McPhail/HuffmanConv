public class HuffmanTree {

    HuffmanNode root;

    public HuffmanTree(HuffmanNode huff) {
        this.root = huff;
    }

    static BinaryHeap legendToHeap(String legend) {

        BinaryHeap outputHeap = new BinaryHeap();
        while (legend.length() > 1) {
            char letter = legend.charAt( 0);
            legend = legend.substring(2);
            String s = legend.split(" ")[0];
            legend = legend.substring(Math.min(s.length() + 1, legend.length()));
            double freq = Double.parseDouble(s);
            HuffmanNode newNode = new HuffmanNode(Character.toString(letter), freq);
            outputHeap.insert(newNode);
        }
        return outputHeap;
    }

    static HuffmanTree createFromHeap(BinaryHeap b) {
        while (b.getSize() > 1) {
            HuffmanNode min1 = (HuffmanNode) b.deleteMin();
            HuffmanNode min2 = (HuffmanNode) b.deleteMin();
            HuffmanNode newNodeToAdd = new HuffmanNode(min1, min2);
            b.insert(newNodeToAdd);
        }
        return new HuffmanTree((HuffmanNode) b.findMin());
    }

    public void printLegend() {
        printLegend(root, "");
    }

    void printLegend(HuffmanNode huff, String s) {
        if (huff.letter.length() > 1) {
            printLegend(huff.left, s + "0");
            printLegend(huff.right, s + "1");
        } else {
            System.out.println((huff.letter + "=" + s));
        }
    }
}

