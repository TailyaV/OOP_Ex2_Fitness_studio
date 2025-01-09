package gym.management.Sessions;

import gym.customers.Client;
import gym.customers.Instructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * The MachinePilates class represents a Pilates session that is conducted using machines. It implements the Session interface, which outlines the necessary methods for a session's functionality. This class manages details such as price, quantity, time, participants, and the instructor.
 */
public class MachinePilates implements Session {
    private final int price = 80;
    private final int finalQuantity = 10;
    private int quantity = 10;
    private Instructor instructor;
    private ForumType forumType;
    private String time;
    private ArrayList<Client> participants = new ArrayList<>();

    /**
     * Takes the session time (s), forum type (forumType), and instructor (i2) as parameters. It initializes the session with these values.
     * @param s
     * @param forumType
     * @param i2
     */
    public MachinePilates(String s, ForumType forumType, Instructor i2){
        this.time = s;
        this.forumType = forumType;
        this.instructor = i2;
    }

    /**
     * Returns the price of the session
     * @return
     */
    @Override
    public int getPrice() {
        return this.price;
    }

    /**
     * Returns the current available quantity of spots for the session.
     * @return
     */
    @Override
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Returns the forum type of the session.
     * @return
     */
    @Override
    public ForumType getType() {
        return forumType;
    }

    /**
     * Returns the type of session as a string ("MachinePilates").
     * @return
     */
    @Override
    public String getTypeString() {
        return "MachinePilates";
    }

    /**
     * Returns the list of participants
     * @return
     */
    @Override
    public ArrayList<Client> getParticipants() {
        return this.participants;
    }

    /**
     * Returns the time of the session.
     * @return
     */
    @Override
    public String getTime(){
        return this.time;
    }

    /**
     * Converts the session time from the string format into a standardized format (yyyy-MM-dd'T'HH:mm).
     * @return
     */
    @Override
    public String getFormatTime() {
        String[] arr = this.time.split(" ");
        String[] yearMonthDay = arr[0].split("-");
        String[] hourMinute = arr[1].split(":");
        int year = Integer.parseInt(yearMonthDay[2]);
        int month = Integer.parseInt(yearMonthDay[1]);
        int day = Integer.parseInt(yearMonthDay[0]);
        int hour = Integer.parseInt(hourMinute[0]);
        int minute = Integer.parseInt(hourMinute[1]);
        LocalDateTime dataTime = LocalDateTime.of(year, month, day, hour, minute);
        dataTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        return dataTime.toString();
    }

    /**
     * Updates the message array of a specific client (c) with a new message (newMassage).
     * @param c
     * @param newMassage
     */
    @Override
    public void update(Client c, String newMassage) {
        c.getMassgaeArry().add(newMassage);
    }

    /**
     * Decreases the number of available spots by 1, as long as there are spots available.
     */
    @Override
    public void setQuantityMinus() {
        if (quantity > 0) {
            this.quantity = this.quantity - 1;
        }
    }

    /**
     * Returns the maximum number of spots available for the session.
     * @return
     */
    @Override
    public int getFinalQuantity() {
        return this.finalQuantity;
    }

    /**
     * Returns the instructor for the session.
     * @return
     */
    @Override
    public Instructor getInstractor() {
        return this.instructor;
    }

}
