import static java.lang.Integer.min;

public class MyStack<E> {
    private Object[] arrayStackLIFO;
    private int head = 0;
    private int tail = -1;
    private int size = 0;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    public MyStack(){
        arrayStackLIFO = new Object[10];
    }

    // збільшуємо масив
    private Object[] expandList(){
        if(arrayStackLIFO.length == MAX_ARRAY_SIZE){
            throw new IllegalStateException("Sorry, array too big");
        }
        int expandListOn = min(5, MAX_ARRAY_SIZE-arrayStackLIFO.length);
        Object[] newArrayQueueFIFO = new Object[arrayStackLIFO.length + expandListOn];
        for (int i=0; i<arrayStackLIFO.length; i++){
            newArrayQueueFIFO[i] = arrayStackLIFO[i];
        }
        return newArrayQueueFIFO;
    }

    //додає елемент в кінець
    public boolean push(E value){
        if (value == null)
            throw new NullPointerException("Sorry, element cannot be null");
        if (arrayStackLIFO.length == tail){
            arrayStackLIFO = expandList();
        }
        tail ++;
        arrayStackLIFO[tail] = value;
        size = tail-head+1;
        return true;
    }

    private E elementTail() {
        if (head > tail) return null;
        return (E) arrayStackLIFO[tail];
    }

    //повертає останній елемент з черги і видаляє його з колекції
    public E poll(){
        E element = elementTail();
        if (element != null){
            arrayStackLIFO[tail] = null;
            tail--;
            size = tail-head+1;
        }
        return element;
    }

    //повертає останій елемент стеку та видаляє його з колекції
    public E remove(){
        if (size == 0)
            throw new IllegalStateException("Sorry, array empty");
        return poll();
    }

    //очищає колекцію
    public void clear(){
        for (int i=head; i<=tail; i++){
            arrayStackLIFO[i] = null;
        }
        head = 0;
        tail = -1;
        size = 0;
    }

    //повертає розмір колекції
    public int size(){
        return size;
    }

    //повертає останій елемент з черги
    public E peek(){
        return elementTail();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i=head; i<=tail; i++){
            result.append(arrayStackLIFO[i]);
            if (i<tail) result.append(", ");
        }
        return  "myArrayList={" + result + '}';
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(3);
        myStack.push(5);
        System.out.println("Added 1,3,5 = "+myStack);
        System.out.println("element tail = "+myStack.peek());
        System.out.println("poll tail = "+myStack.poll() +" "+ myStack);
        System.out.println("element tail = "+myStack.peek());
        System.out.println("poll tail = "+myStack.poll() +" "+ myStack);
        System.out.println("element tail = "+myStack.peek());
        System.out.println("remove tail = "+myStack.remove() +" "+ myStack);
        //System.out.println("remove tail = "+myStack.remove() +" "+ myStack);
        myStack.push(2);
        myStack.push(4);
        myStack.push(6);
        System.out.println("Added 2,4,6 = "+myStack);
        System.out.println("size = "+myStack.size());
        myStack.clear();
        System.out.println("Clear "+myStack);
        System.out.println("size = "+myStack.size());
    }
}
