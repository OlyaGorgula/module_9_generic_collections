import javax.management.Query;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Deque<Integer> listq = new ArrayDeque<>();
        listq.remove();
        //Queue<Integer> listq = new ArrayDeque<>();
        listq.add(1);
        listq.add(3);
        listq.add(5);
        System.out.println("Added 1,3,5 = "+listq);
        System.out.println("element [0] = "+listq.peek());
        System.out.println("remove [0] = "+listq.poll() +" "+ listq);
        System.out.println("size = "+listq.size());
        listq.clear();
        System.out.println("Clear "+listq);

        ArrayList<Integer> list = new ArrayList<>();
        //LinkedList<Integer> list = new LinkedList<Integer>();
        //MyArrayList<Integer> list = new MyArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        //MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(3);
        list.add(5);
        System.out.println("Added 1,3,5 = "+list);
        System.out.println("element [0] = "+list.get(0));
        System.out.println("element [1] = "+list.get(1));
        System.out.println("element [2] = "+list.get(2));
        System.out.println("remove [0] = "+list.remove(0) +" "+ list);
        System.out.println("remove [1] = "+list.remove(0) +" "+ list);
        System.out.println("remove [2] = "+list.remove(0) +" "+ list);
        //System.out.println("remove [3] = "+list.remove(0) +" "+ list);
        list.add(2);
        list.add(4);
        list.add(6);
        System.out.println("Added 2,4,6 = "+list);
        System.out.println("size = "+list.size());
        list.clear();
        System.out.println("Clear "+list);


        System.out.println("*************************************************");


    }

}