package circularlinkedlist.onlineticketreservationsystem;

public class Node {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Node next;
    //constructor
    Node(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }

}
