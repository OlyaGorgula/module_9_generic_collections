import java.util.Arrays;

public class MyArrayList <E>{
    private E[] myArrayList;
    private int size;

    public MyArrayList(){
        size = 0;
        myArrayList = (E[]) new Object[10];
    }

    //додає елемент в кінець
    public void add(E value){
        if (myArrayList.length == size){
            myArrayList = expandList();
        }
        myArrayList[size] = value;
        size ++;
    }

    private E[] expandList(){
        E[] newArrayList = (E[]) new Object[myArrayList.length+5];
        for (int i=0; i<myArrayList.length; i++){
            newArrayList[i] = myArrayList[i];
        }
        return newArrayList;
    }

    //видаляє елемент із вказаним індексом
    public E remove(int index){
        if (index >= size ){
            return null;
        }
        E removeElement = myArrayList[index];
        for (int i=index; i<size; i++){
            myArrayList[i] = myArrayList[i+1];
        }
        size--;
        return removeElement;
    }

    //очищає колекцію
    public void clear(){
        for (int i=0; i<size; i++){
            myArrayList[i] = null;
        }
        myArrayList = (E[]) new Object[10];
        size = 0;
    }

    //повертає розмір колекції
    public int size(){
        return size;
    }

    //повертає елемент за індексом
    public E get(int index){
        if (index < size ){
            return myArrayList[index];
        }
        return null;
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
        System.out.println("remove [3] = "+myArrayList.remove(0) +" "+ myArrayList);
        myArrayList.add(2);
        myArrayList.add(4);
        myArrayList.add(6);
        System.out.println("Added 2,4,6 = "+myArrayList);
        System.out.println("size = "+myArrayList.size());
        myArrayList.clear();
        System.out.println("Clear "+myArrayList);
    }
}
