package circularlinkedlist.onlineticketreservationsystem;

public class ReservationLinkedList {
    private Node last;
    private int size;

    public ReservationLinkedList() {
        this.last = null;
        this.size = 0;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Node newNode = new Node(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            // Insert the new node at the end
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        size++;
        System.out.println("Ticket added: " + ticketID);
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Node current = last.next;
        Node previous = last;

        // Traverse the circular linked list to find the ticket
        do {
            if (current.ticketID == ticketID) {
                if (current == last && current.next == last) {
                    // If it's the only node in the list
                    last = null;
                } else {
                    // Adjust the circular links
                    previous.next = current.next;
                    if (current == last) {
                        last = previous;
                    }
                }
                size--;
                System.out.println("Ticket " + ticketID + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket " + ticketID + " not found.");
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }

        Node current = last.next;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName
                    + ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber
                    + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String customerName, String movieName) {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }

        Node current = last.next;
        boolean found = false;

        do {
            if (current.customerName.equalsIgnoreCase(customerName) || current.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Found Ticket - Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName
                        + ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber
                        + ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("No matching ticket found.");
        }
    }

    // Calculate the total number of booked tickets
    public void totalTickets() {
        System.out.println("Total number of booked tickets: " + size);
    }
}
