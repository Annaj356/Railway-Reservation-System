import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookTicketFrame extends JFrame {
    private JTextField bookingIdField; 
    private JTextField passengerNameField;
    private JTextField trainNameField;
    private JTextField seatNumberField;
    private JTextField travelDateField;
    private JTextField travelTimeField;

    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private final double ticketPrice = 50.0; 

    public BookTicketFrame() {
        setTitle("Book Ticket");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Booking ID:")); 
        bookingIdField = new JTextField();
        add(bookingIdField);

        add(new JLabel("Passenger Name:"));
        passengerNameField = new JTextField();
        add(passengerNameField);

        add(new JLabel("Train Name:"));
        trainNameField = new JTextField();
        add(trainNameField);

        add(new JLabel("Seat Number:"));
        seatNumberField = new JTextField();
        add(seatNumberField);

        add(new JLabel("Travel Date (YYYY-MM-DD):"));
        travelDateField = new JTextField();
        add(travelDateField);

        add(new JLabel("Travel Time (HH:MM):"));
        travelTimeField = new JTextField();
        add(travelTimeField);

        JButton bookButton = new JButton("Book Ticket");
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookTicket();
            }
        });
        add(bookButton);
    }

    private void bookTicket() {
        String bookingId = bookingIdField.getText(); // Get the Booking ID
        String passengerName = passengerNameField.getText();
        String trainName = trainNameField.getText();
        String seatNumber = seatNumberField.getText();
        String travelDate = travelDateField.getText();
        String travelTime = travelTimeField.getText();

        // Confirmation dialog before booking
        int confirmation = JOptionPane.showConfirmDialog(this,"Do you want to book this ticket?\n" +
                        "Booking ID: " + bookingId + "\n" + 
                        "Passenger Name: " + passengerName + "\n" +
                        "Train Name: " + trainName + "\n" +
                        "Seat Number: " + seatNumber + "\n" +
                        "Travel Date: " + travelDate + "\n" +
                        "Travel Time: " + travelTime + "\n" +
                        "Total Price: Rs" + ticketPrice,
                "Confirm Booking", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            
            Reservation reservation = new Reservation(passengerName, trainName, seatNumber, travelDate, travelTime, ticketPrice);
            reservations.add(reservation);

            // Clear input fields
            bookingIdField.setText(""); 
            passengerNameField.setText("");
            trainNameField.setText("");
            seatNumberField.setText("");
            travelDateField.setText("");
            travelTimeField.setText("");

            
            JOptionPane.showMessageDialog(this, reservation.generateBill());
        }
    }

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }
}
[10:28 AM, 11/27/2024] Vettikuth Veni: import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelBookingFrame extends JFrame {
    private JTextField bookingIdField;

    public CancelBookingFrame() {
        setTitle("Cancel Booking");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Booking ID:"));
        bookingIdField = new JTextField();
        add(bookingIdField);

        JButton cancelButton = new JButton("Cancel Booking");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelBooking();
            }
        });
        add(cancelButton);
    }

    private void cancelBooking() {
        try {
            int bookingId = Integer.parseInt(bookingIdField.getText());
            boolean found = false;

            // Search for the reservation by booking ID and remove it
            for (int i = 0; i < BookTicketFrame.getReservations().size(); i++) {
                if (BookTicketFrame.getReservations().get(i).getBookingId() == bookingId) {
                    BookTicketFrame.getReservations().remove(i);
                    found = true;
                    break;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(this, "Booking ID " + bookingId + " has been canceled successfully.");
                bookingIdField.setText(""); 
            } else {
                JOptionPane.showMessageDialog(this, "Booking ID not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Booking ID.");
        }
    }
}
