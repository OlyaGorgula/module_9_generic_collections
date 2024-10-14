public class MyLinkedList<E>{

    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList(){
    }

    //додає елемент в кінець
    public void add(E value){
        linkLast(value);
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    //видаляє елемент із вказаним індексом
    public E remove(int index){
        checkElementIndex(index);
        return unlink(node(index));
    }

    //очищає колекцію
    public void clear(){
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    //повертає розмір колекції
    public int size(){
        return size;
    }

    // повертає елемент за індексом
    public E get(int index){
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<E> x = first;
        for (int i=0; i<size; i++){
            result.append(x.item);
            x = x.next;
            if(i < size-1) result.append(", ");
        }
        return  "myLinkedList={" + result + '}';
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(3);
        myLinkedList.add(5);
        System.out.println("Added 1,3,5 = "+myLinkedList);
        System.out.println("element [0] = "+myLinkedList.get(0));
        System.out.println("element [1] = "+myLinkedList.get(1));
        System.out.println("element [2] = "+myLinkedList.get(2));
        System.out.println("remove [0] = "+myLinkedList.remove(0) +" "+ myLinkedList);
        System.out.println("remove [1] = "+myLinkedList.remove(0) +" "+ myLinkedList);
        System.out.println("remove [2] = "+myLinkedList.remove(0) +" "+ myLinkedList);
        //System.out.println("remove [3] = "+myLinkedList.remove(0) +" "+ myLinkedList);
        myLinkedList.add(2);
        myLinkedList.add(4);
        myLinkedList.add(6);
        System.out.println("Added 2,4,6 = "+myLinkedList);
        System.out.println("size = "+myLinkedList.size());
        myLinkedList.clear();
        System.out.println("Clear "+myLinkedList);
    }
}
