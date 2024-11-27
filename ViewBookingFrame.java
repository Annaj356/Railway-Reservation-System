import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewBookingFrame extends JFrame {
    public ViewBookingFrame() {
        setTitle("View Bookings");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        ArrayList<Reservation> reservations = BookTicketFrame.getReservations();
        if (reservations.isEmpty()) {
            textArea.setText("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                textArea.append(reservation.generateBill() + "\n\n");
            }
        }
    }
}
