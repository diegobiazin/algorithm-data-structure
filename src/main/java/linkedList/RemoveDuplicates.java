package linkedList;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

}

public class RemoveDuplicates {
    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        Node head = null;
//        int T = sc.nextInt();
//        while (T-- > 0) {
//            int ele = sc.nextInt();
//            head = insert(head, ele);
//        }
//        head = removeDuplicates(head);
//        display(head);

        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        String[] line2 = sc.nextLine().split(" ");
        int d1 = Integer.parseInt(line1[0]);
        int m1 = Integer.parseInt(line1[1]);
        int y1 = Integer.parseInt(line1[2]);
        int resultD1 = d1 + m1 + y1;

        int d2 = Integer.parseInt(line2[0]);
        int m2 = Integer.parseInt(line2[1]);
        int y2 = Integer.parseInt(line2[2]);
        int resultD2 = d2 + m2 + y2;


        if (y1 > y2)
            System.out.println(10000);
        else if (resultD1 <= resultD2 || y1 < y2)
            System.out.println(0);
        else if ((m1 + y1) == (m2 + y2))
            System.out.println((d1 - d2) * 15);
        else
            System.out.println((m1 - m2) * 500);

    }

    static Node removeDuplicates(Node head) {
        if (head == null)
            return head;

        Node prevNode = head;
        Node current = prevNode.next;

        if (current == null)
            return head;

        Set<Integer> duplicates = new HashSet<>();
        duplicates.add(prevNode.data);

        while (current != null) {
            if (duplicates.contains(current.data)) {
                prevNode.next = current.next;
            } else {
                duplicates.add(current.data);
                prevNode = current;
            }
            current = current.next;
        }
        return head;
    }

}
