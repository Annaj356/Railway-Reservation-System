import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class app extends JFrame {

    public app() {
        setTitle("Railway Reservation System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        JButton bookTicketButton = new JButton("Book Ticket");
        JButton cancelBookingButton = new JButton("Cancel Booking");
        JButton viewBookingButton = new JButton("View Booking");
        JButton exitButton = new JButton("Exit");

        bookTicketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BookTicketFrame().setVisible(true);
            }
        });

        cancelBookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CancelBookingFrame().setVisible(true);
            }
        });

        viewBookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ViewBookingFrame().setVisible(true);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(bookTicketButton);
        add(cancelBookingButton);
        add(viewBookingButton);
        add(exitButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            app app = new app();
            app.setVisible(true);
        });
    }
}
