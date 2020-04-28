public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String data = "A 20 E 24 G 3 H 4 I 17 L 6 N 5 O 10 S 8 V 1 W 2";
        BinaryHeap heap = HuffmanTree.legendToHeap(data);
        heap.printHeap();
        HuffmanTree tree = HuffmanTree.createFromHeap(heap);
        tree.printLegend();
    }
}
