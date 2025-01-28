package singlylinkedlist.studentrecordmanagement;

public class StudentLinkedList {
    Node head;
    //constructor
    public StudentLinkedList(){
        this.head = null;
    }

    //add at first of linked list
    public void addFirst(int rollNumber, String name, int age, String grade){
        //node creation
        Node newNode = new Node(rollNumber, name, age, grade);
        if(head == null){
            head = newNode;
            return;
        }
        // new node that is adding is set as head and the
        //value of head is given to the next node after new node
        newNode.next = head;
        head = newNode;
    }

    // add at the last of list
    public void addAtLast(int rollNumber, String name, int age, String grade){
        //node creation
        Node newNode = new Node(rollNumber, name, age, grade);
        if(head == null){
            head = newNode;
            return;
        }
        Node currentNode = head;
        //traverse to the end of list
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        /*set the next pointer of last
        node to point to new node
         */
        currentNode.next = newNode;
    }

    //add node at any specific position
    public void addSpecificPosition(int position, int rollNumber, String name, int age, String grade){
        Node newNode = new Node(rollNumber, name, age, grade);
        if(position == 0){
          newNode.next = head;
          head = newNode;
        }
        Node currentNode = head;
        //loop to reach position where insertion is occurring
        for(int i=0;i< position-1 && currentNode != null; i++){
            currentNode = currentNode.next;
        }
        if(currentNode != null){
            // the new node next will point to next node of list
            //and current node will point to newnode
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }
    //Delete a student record by Roll Number
    public void deleteStudentRecord(int rollNumber){
        Node temp = head;
       while (temp.next.rollNumber != rollNumber){
           temp = temp.next;
           if(temp == null){
               System.out.println("Record not found");
               return;
           }

       }
        temp.next = temp.next.next;
    }
    //Search for a student record by Roll Number
    public Node searchStudentRecord(int rollNumber){
        Node temp = head;
        while (temp != null){
            // if rollnumber inside node is equal to the target roll number
            if (temp.rollNumber == rollNumber){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    //Update a student's grade based on their Roll Number
    public void updateStudentRecord(int rollNumber, String newGrade){
        //call search method to search record and update grade
        Node record1 = searchStudentRecord(rollNumber);
        if (record1 != null){
            record1.grade = newGrade;
            System.out.println("Updated grade for student: Rollnumber: " + rollNumber);
        }else
            System.out.println("Record not found");
    }

    //display list
    public void displayList(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null){
            System.out.println("Roll number: " + currentNode.rollNumber + " |  Name: " + currentNode.name + " |  Age: " + currentNode.age + " |  Grade: " + currentNode.grade);
            currentNode = currentNode.next;
        }
    }


}
