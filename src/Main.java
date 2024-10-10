import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        //LinkedList<Integer> list = new LinkedList<Integer>();
        //MyArrayList<Integer> list = new MyArrayList<>();
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