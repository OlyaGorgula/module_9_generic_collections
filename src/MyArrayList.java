import java.util.Objects;

import static java.lang.Integer.min;

public class MyArrayList <E>{
    private Object[] myArrayList;
    private int size;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public MyArrayList(){
        size = 0;
        myArrayList = new Object[10];
    }

    //додає елемент в кінець
    public boolean add(E value){
        if (myArrayList.length == size){
            myArrayList = expandList();
        }
        myArrayList[size] = value;
        size ++;
        return true;
    }

    private Object[] expandList(){
        if(myArrayList.length == MAX_ARRAY_SIZE){
            throw new IllegalStateException("Sorry, array too big");
        }
        int expandListOn = min(5, MAX_ARRAY_SIZE-myArrayList.length);
        Object[] newArrayList = new Object[myArrayList.length + expandListOn];
        for (int i=0; i<myArrayList.length; i++){
            newArrayList[i] = myArrayList[i];
        }
        return newArrayList;
    }

    private void removeElement(int index){
        for (int i=index; i<size; i++){
            myArrayList[i] = myArrayList[i+1];
        }
        size--;
    }

    //видаляє елемент із вказаним індексом
    public E remove(int index){
        Objects.checkIndex(index, size);
        E removeElement = (E) myArrayList[index];
        removeElement(index);
        return removeElement;
    }

    //очищає колекцію
    public void clear(){
        for (int i=0; i<size; i++){
            myArrayList[i] = null;
        }
        size = 0;
    }

    //повертає розмір колекції
    public int size(){
        return size;
    }

    //повертає елемент за індексом
    public E get(int index){
        Objects.checkIndex(index, size);
        return (E) myArrayList[index];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i=0; i<size; i++){
            result.append(myArrayList[i]);
            if (i<size-1) result.append(", ");
        }
        return  "myArrayList={" + result + '}';
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5);
        System.out.println("Added 1,3,5 = "+myArrayList);
        System.out.println("element [0] = "+myArrayList.get(0));
        System.out.println("element [1] = "+myArrayList.get(1));
        System.out.println("element [2] = "+myArrayList.get(2));
        System.out.println("remove [0] = "+myArrayList.remove(0) +" "+ myArrayList);
        System.out.println("remove [1] = "+myArrayList.remove(0) +" "+ myArrayList);
        System.out.println("remove [2] = "+myArrayList.remove(0) +" "+ myArrayList);
        //System.out.println("remove [3] = "+myArrayList.remove(0) +" "+ myArrayList);
        myArrayList.add(2);
        myArrayList.add(4);
        myArrayList.add(6);
        System.out.println("Added 2,4,6 = "+myArrayList);
        System.out.println("size = "+myArrayList.size());
        myArrayList.clear();
        System.out.println("Clear "+myArrayList);
    }
}
