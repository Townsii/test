package src.code.linkedlist_test;

import java.util.LinkedList;

import static src.code.linkedlist_test.ReverseLinkedList.reverseMyLinkedList;


public class MyLinkedList {

    public Node head;
    public int size;

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        System.out.println("空链表");
        sopMyLinkedList(myLinkedList);

        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.add(8);

        System.out.println("\n四元素链表");
        System.out.println("size:"+myLinkedList.size);
        sopMyLinkedList(myLinkedList);


        myLinkedList.rm(1);

        System.out.println("\n三元素链表");
        System.out.println("size:"+myLinkedList.size);
        sopMyLinkedList(myLinkedList);

        System.out.println("\n反转链表");
        MyLinkedList reverseMyLinkedList = reverseMyLinkedList(myLinkedList);
        sopMyLinkedList(reverseMyLinkedList);


    }

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(int data) {
        if (this.size == 0) {
            this.head = new Node(data);
            size++;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(data));
            size++;
        }
    }

    public void rm(int index) {

        if (index < 0 || index > size - 1) {
            System.out.println("ERROR");
        } else if (index == 0) {
            this.head = this.head.getNext();
            size--;
        } else {
            Node temp = this.head;
            for (int i = 0; i <= index-2; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            size--;
        }

    }


    public int getSize() {
        return this.size;
    }


    public static void sopMyLinkedList(MyLinkedList myLinkedList){
        if(myLinkedList.head == null)
            System.out.println("null");
        else {
            System.out.println(myLinkedList.head.getData());
            Node temp = myLinkedList.head;
            while (temp.getNext() != null) {
                System.out.println(temp.getNext().getData());
                temp = temp.getNext();
            }
        }
    }

    public static void sopNode(Node head) {
        if (head == null)
            System.out.println("null");
        else {
            System.out.println(head.getData());
            Node temp = head;
            while (temp.getNext() != null) {
                System.out.println(temp.getNext().getData());
                temp = temp.getNext();
            }
        }
    }
}
