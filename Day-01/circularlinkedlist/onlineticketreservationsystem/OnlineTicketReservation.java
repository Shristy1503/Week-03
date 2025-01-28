package circularlinkedlist.onlineticketreservationsystem;

public class OnlineTicketReservation {
    public static void main(String[] args) {
        ReservationLinkedList system = new ReservationLinkedList();

        // Adding tickets
        system.addTicket(1, "Arjun", "Avatar", "A1", "2025-01-28T10:15:30");
        system.addTicket(2, "Shristy", "Spider Man", "B2", "2025-01-28T11:00:00");
        system.addTicket(3, "Nancy", "Harry Potter", "C2", "2025-01-28T12:30:15");

        // Display tickets
        system.displayTickets();

        // Search for a ticket
        system.searchTicket("Bob", "");

        // Remove a ticket
        system.removeTicket(2);

        // Display tickets after removal
        system.displayTickets();

        // Calculate total tickets
        system.totalTickets();
    }
}
