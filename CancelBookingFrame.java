import javax.swing.*;
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
