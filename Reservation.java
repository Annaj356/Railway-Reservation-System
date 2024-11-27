import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Reservation {
    private int bookingId; 
    private String passengerName;
    private String trainName;
    private String seatNumber;
    private String travelDate;
    private String travelTime;
    private double price;

    private static int idCounter = 1; 
    public Reservation(String passengerName, String trainName, String seatNumber, String travelDate, String travelTime, double price) {
        this.bookingId = idCounter++; 
        this.passengerName = passengerName;
        this.trainName = trainName;
        this.seatNumber = seatNumber;
        this.travelDate = travelDate;
        this.travelTime = travelTime;
        this.price = price;
    }

    public int getBookingId() {
        return bookingId; 
    }

    public String generateBill() {
        return "Booking ID: " + bookingId + "\n" +
               "Passenger Name: " + passengerName + "\n" +
               "Train Name: " + trainName + "\n" +
               "Seat Number: " + seatNumber + "\n" +
               "Travel Date: " + travelDate + "\n" +
               "Travel Time: " + travelTime + "\n" +
               "Total Price: $" + price;
    }
}
