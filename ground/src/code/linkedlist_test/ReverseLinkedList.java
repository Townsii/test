package src.code.linkedlist_test;


import static src.code.linkedlist_test.MyLinkedList.sopNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(null);
        Node reverse = reverseNode(n0);
        sopNode(reverse);
    }

    public static Node reverseNode(Node head) {
        if (head == null || head.getNext() == null)
            return head;
        else {
            Node pre = head;
            Node cur = head.getNext();
            head.setNext(null);
            Node next = null;
            while (cur != null) {
                next = cur.getNext();
                cur.setNext(pre);
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }


    public static MyLinkedList reverseMyLinkedList(MyLinkedList myLinkedList) {
        Node head = myLinkedList.head;
        if (head == null || head.getNext() == null) {
            return myLinkedList;
        } else {
            MyLinkedList res = new MyLinkedList();

            //pre cur交替反转引用，next做中间变量
            Node pre = head;
            Node cur = head.getNext();
            Node next = null;
            //防止出现循环引用
            head.setNext(null);

            while (cur != null) {
                next = cur.getNext();
                cur.setNext(pre);
                pre = cur;
                cur = next;
            }

            //将最后的Node给res作为head
            res.head = pre;
            return res;
        }
    }

}



