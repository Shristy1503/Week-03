package singlylinkedlist.studentrecordmanagement;

public class StudentRecordsLinkedList {
    public static void main(String[] args) {
         StudentLinkedList students = new StudentLinkedList();
         // add student at start
        students.addFirst(101, "Shristy", 21, "A");
        students.addFirst(102, "Arjun", 22, "B");

        // add student at last
        students.addAtLast(107, "Nancy", 20, "B");

        //add at specific position
        students.addSpecificPosition(2, 100, "Muskan", 19, "A");
        //display the list
        System.out.println("Student record list: ");
        students.displayList();

        // search student by rollnumber
        Node student1 = students.searchStudentRecord(100);
        if (student1 != null){
            System.out.println("Found record of student : Roll number: " + student1.rollNumber + " | Name: " + student1.name);
        }else
            System.out.println("Record not found");

        //delete the record and display
        students.deleteStudentRecord(101);
        students.displayList();
        System.out.println("Record is deleted");

        // update students grade and display
        students.updateStudentRecord(102, "A");
        System.out.println("Updated record: ");
        students.displayList();
    }
}
