package singlylinkedlist.studentrecordmanagement;

public class Node {
    int rollNumber;
    String name;
    int age;
    String grade;
    Node next;
    //constructor
    public Node(int rollNumber, String name, int age, String grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;

    }
}
