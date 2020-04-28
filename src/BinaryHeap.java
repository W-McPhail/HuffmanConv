//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class BinaryHeap<E extends Comparable> {
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;
    private E[] array;

    public BinaryHeap() {
        this(100);
    }

    public BinaryHeap(int capacity) {
        this.currentSize = 0;
        this.array = new Comparable[capacity + 1];
    }

    public BinaryHeap(E[] items) {
        this.currentSize = items.length;
        this.array = new Comparable[(this.currentSize + 2) * 11 / 10];
        int i = 1;
        Comparable[] var3 = items;
        int var4 = items.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            E item = var3[var5];
            this.array[i++] = item;
        }

        this.buildHeap();
    }

    public void insert(E x) {
        if (this.currentSize == this.array.length - 1) {
            this.enlargeArray(this.array.length * 2 + 1);
        }

        int hole;
        for(hole = ++this.currentSize; hole > 1 && x.compareTo(this.array[hole / 2]) < 0; hole /= 2) {
            this.array[hole] = this.array[hole / 2];
        }

        this.array[hole] = x;
    }

    private void enlargeArray(int newSize) {
        E[] old = this.array;
        this.array = new Comparable[newSize];

        for(int i = 0; i < old.length; ++i) {
            this.array[i] = old[i];
        }

    }

    public E findMin() {
        if (this.isEmpty()) {
            throw new UnderflowException();
        } else {
            return this.array[1];
        }
    }

    public E deleteMin() {
        if (this.isEmpty()) {
            throw new UnderflowException();
        } else {
            E minItem = this.findMin();
            this.array[1] = this.array[this.currentSize--];
            this.percolateDown(1);
            return minItem;
        }
    }

    private void buildHeap() {
        for(int i = this.currentSize / 2; i > 0; --i) {
            this.percolateDown(i);
        }

    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public void makeEmpty() {
        this.currentSize = 0;
    }

    public void printHeap() {
        for(int i = 1; i <= this.currentSize; ++i) {
            Comparable var10001 = this.array[i];
            System.out.print(var10001 + " ");
        }

        System.out.println();
    }

    private void percolateDown(int hole) {
        int child;
        Comparable tmp;
        for(tmp = this.array[hole]; hole * 2 <= this.currentSize; hole = child) {
            child = hole * 2;
            if (child != this.currentSize && this.array[child + 1].compareTo(this.array[child]) < 0) {
                ++child;
            }

            if (this.array[child].compareTo(tmp) >= 0) {
                break;
            }

            this.array[hole] = this.array[child];
        }

        this.array[hole] = tmp;
    }

    public int getSize() {
        return this.currentSize;
    }
}
