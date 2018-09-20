package list;

import java.util.LinkedList;
import java.util.Stack;

public class MyLinkedList<T> {

    int size;

    Node head;

    public void add(int index, T o){
        if (index <= size) {
            if (head == null) {
                head = new Node(o);
                size++;
                return;
            }

            if (index == 0) {
                Node temp = head;

                Node node = new Node(o);
                head = node;
                head.next = temp;
            } else {
                Node point = head;
                for (int i = 0; i < index - 1; i++) {
                    point = point.next;
                }
                Node temp = point.next;
                point.next = new Node(o);
                point.next.next = temp;
            }
            size++;


        }

    }
    public void add(T o){
        if (head == null) {
            head = new Node(o);

        } else {
            Node point = head;
            for (int i = 0; i < size - 1; i++) {
                point = point.next;
            }
            point.next = new Node(o);
        }

        size++;
    }
    public void remove(int index) {

    }
    public T get(int index){

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return (T) node.value;

    }

    public MyLinkedList() {
        size = 0;
    }



    private class Node<T> {

        Object value;
        Node next;

        public Node(T o) {
            value = o;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(1, 3);
        list.add(1, 3);
        list.add(1, 3);
        list.add(3);
        for (int i = 0; i < list.size; i++) {
            System.out.println(list.get(i));
        }

        int times = 100000000;
        long time = System.currentTimeMillis();

        recursion(times);
        System.out.println(System.currentTimeMillis() - time);



        time = System.currentTimeMillis();

        stack(times);
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();

        loop(times);
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void recursion(int l) {

        if (l-- > 0) {
            recursion(l);
        }

    }
    public static void stack(int l) {
        Stack<Integer> stack = new Stack<>();
        while (l-- > 0) {
            stack.push(1);
        }
        while (stack.size() > 0) {
            stack.pop();
        }
    }
    public static void loop(int l) {

        for (long i = 0; i < l; i++) {

        }
    }
}
