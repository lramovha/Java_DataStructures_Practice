import java.util.*;
// import java.io.*;

public class simpleLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list);

        list.addFirst("Z");
        list.addLast("E");
        System.out.println(list);

        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.set(2, "F");
        System.out.println(list);

        System.out.println(list.get(2));
        
        
    }
}