import java.util.Arrays;

import static java.lang.Integer.min;

public class MyQueue<E> {
    private Object[] arrayQueueFIFO; // arrayQueueFIFO
    private int head;
    private int tail;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    public MyQueue(){
        arrayQueueFIFO = new Object[10];
        head = tail = 0;
    }

    //додає елемент в кінець
    public boolean add(E value){
        if (arrayQueueFIFO.length == tail){
            arrayQueueFIFO = expandList();
        }
        arrayQueueFIFO[tail] = value;
        tail ++;
        return true;
    }

    // збільшуємо масив
    private Object[] expandList(){
        if(arrayQueueFIFO.length == MAX_ARRAY_SIZE){
            throw new IllegalStateException("Sorry, array too big");
        }
        int expandListOn = min(5, MAX_ARRAY_SIZE-arrayQueueFIFO.length);
        Object[] newArrayQueueFIFO = new Object[arrayQueueFIFO.length + expandListOn];
        for (int i=0; i<arrayQueueFIFO.length; i++){
            newArrayQueueFIFO[i] = arrayQueueFIFO[i];
        }
        return newArrayQueueFIFO;
    }

    //очищає колекцію
    public void clear(){
        for (int i=head; i<tail; i++){
            arrayQueueFIFO[i] = null;
        }
        head = tail = 0;
        // Є питання. Коли на масив чи то об'єкт ні яка змінна не посилається, то з пам'яти його видаляє java?
        // чому в воних for es[i] = null, а ні arrayQueueFIFO = new Object[n] ?
    }

    //повертає розмір колекції
    public int size(){
        return tail-head;
    }

    private E elementHead() {
        if (head >= tail) return null;
        return (E) arrayQueueFIFO[head];
    }

    //повертає перший елемент з черги
    public E peek(){
        return elementHead();
    }

    //повертає перший елемент з черги і видаляє його з колекції
    public E poll(){
        E element = elementHead();
        if (element != null){
            arrayQueueFIFO[head] = null;
            head++;
        }
        return element;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i=head; i<tail; i++){
            result.append(arrayQueueFIFO[i]);
            if (i<tail-1) result.append(", ");
        }
        return  "myArrayList={" + result + '}';
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(3);
        myQueue.add(5);
        System.out.println("Added 1,3,5 = "+myQueue);
        System.out.println("element head = "+myQueue.peek());
        System.out.println("poll head = "+myQueue.poll() +" "+ myQueue);
        System.out.println("element head = "+myQueue.peek());
        System.out.println("poll head = "+myQueue.poll() +" "+ myQueue);
        System.out.println("element head = "+myQueue.peek());
        System.out.println("poll head = "+myQueue.poll() +" "+ myQueue);
        System.out.println("poll head = "+myQueue.poll() +" "+ myQueue);
        myQueue.add(2);
        myQueue.add(4);
        myQueue.add(6);
        System.out.println("Added 2,4,6 = "+myQueue);
        System.out.println("size = "+myQueue.size());
        myQueue.clear();
        System.out.println("Clear "+myQueue);
        System.out.println("size = "+myQueue.size());
    }
}
