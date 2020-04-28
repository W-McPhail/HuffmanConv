//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class SinglyLinkedList<E> implements Cloneable {
    private SinglyLinkedList.Node<E> head = null;
    private SinglyLinkedList.Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E first() {
        return this.isEmpty() ? null : this.head.getElement();
    }

    public E last() {
        return this.isEmpty() ? null : this.tail.getElement();
    }

    public void addFirst(E e) {
        this.head = new SinglyLinkedList.Node(e, this.head);
        if (this.size == 0) {
            this.tail = this.head;
        }

        ++this.size;
    }

    public void addLast(E e) {
        SinglyLinkedList.Node<E> newest = new SinglyLinkedList.Node(e, (SinglyLinkedList.Node)null);
        if (this.isEmpty()) {
            this.head = newest;
        } else {
            this.tail.setNext(newest);
        }

        this.tail = newest;
        ++this.size;
    }

    public E removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            E answer = this.head.getElement();
            this.head = this.head.getNext();
            --this.size;
            if (this.size == 0) {
                this.tail = null;
            }

            return answer;
        }
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this.getClass() != o.getClass()) {
            return false;
        } else {
            SinglyLinkedList other = (SinglyLinkedList)o;
            if (this.size != other.size) {
                return false;
            } else {
                SinglyLinkedList.Node walkA = this.head;

                for(SinglyLinkedList.Node walkB = other.head; walkA != null; walkB = walkB.getNext()) {
                    if (!walkA.getElement().equals(walkB.getElement())) {
                        return false;
                    }

                    walkA = walkA.getNext();
                }

                return true;
            }
        }
    }

    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> other = (SinglyLinkedList)super.clone();
        if (this.size > 0) {
            other.head = new SinglyLinkedList.Node(this.head.getElement(), (SinglyLinkedList.Node)null);
            SinglyLinkedList.Node<E> walk = this.head.getNext();

            for(SinglyLinkedList.Node otherTail = other.head; walk != null; walk = walk.getNext()) {
                SinglyLinkedList.Node<E> newest = new SinglyLinkedList.Node(walk.getElement(), (SinglyLinkedList.Node)null);
                otherTail.setNext(newest);
                otherTail = newest;
            }
        }

        return other;
    }

    public int hashCode() {
        int h = 0;

        for(SinglyLinkedList.Node walk = this.head; walk != null; walk = walk.getNext()) {
            h ^= walk.getElement().hashCode();
            h = h << 5 | h >>> 27;
        }

        return h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for(SinglyLinkedList.Node walk = this.head; walk != null; walk = walk.getNext()) {
            sb.append(walk.getElement());
            if (walk != this.tail) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    private static class Node<E> {
        private E element;
        private SinglyLinkedList.Node<E> next;

        public Node(E e, SinglyLinkedList.Node<E> n) {
            this.element = e;
            this.next = n;
        }

        public E getElement() {
            return this.element;
        }

        public SinglyLinkedList.Node<E> getNext() {
            return this.next;
        }

        public void setNext(SinglyLinkedList.Node<E> n) {
            this.next = n;
        }
    }
}
