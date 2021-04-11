import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inheritance {
}

class Difference {
    private int[] elements;
    public int maximumDifference;

    // Add your code here
    public Difference(int[] elements) {
        this.elements = elements;
    }

    public void computeDifference() {
        Arrays.sort(elements);
        int max = elements[elements.length - 1];
        int min = elements[0];
        this.maximumDifference = max - min;
    }

}

abstract class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    abstract void display();
}

class MyBook extends Book {

    Integer price;

    public MyBook(String title, String author, Integer price) {
        super(title, author);
        this.price = price;
    }

    @Override
    void display() {
        System.out.println(
            "Title: " + title +
                "\nAuthor: " + author +
                "\nPrice: " + price
        );
    }
}

class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    Person(String firstName, String lastName, int identification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    public void printPerson() {
        System.out.println(
            "Name: " + lastName + ", " + firstName
                + "\nID: " + idNumber);
    }

}

class Student extends Person {
    private int[] testScores;

    /*
     *   Class Constructor
     *
     *   @param firstName - A string denoting the Person's first name.
     *   @param lastName - A string denoting the Person's last name.
     *   @param id - An integer denoting the Person's ID number.
     *   @param scores - An array of integers denoting the Person's test scores.
     */
    // Write your constructor here
    public Student(String firstName, String lastName, Integer idNumber, int[] testScores) {
        super(firstName, lastName, idNumber);
        this.testScores = testScores;
    }

    /*
     *   Method Name: calculate
     *   @return A character denoting the grade.
     */
    // Write your method here
    public Character calculate() {
        int total = 0;
        char grade;
        for (int i : testScores) {
            total += i;
        }
        int result = total / (testScores.length);
        if (result >= 90 && result <= 100)
            grade = 'O';
        else if (result >= 80 && result < 90)
            grade = 'E';
        else if (result >= 70 && result < 80)
            grade = 'A';
        else if (result >= 55 && result < 70)
            grade = 'P';
        else if (result >= 40 && result < 55)
            grade = 'D';
        else
            grade = 'T';

        return grade;
    }
}

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {

    public static  Node insert(Node head,int data) {Node newNode = new Node(data);
        if (head == null)
            return newNode;

        head.next = insert(head.next, data);
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
        try {
            System.out.println(Integer.parseInt("RES"));
        } catch(NumberFormatException ex) {
            throw new NumberFormatException();
        }
    }
}
