package gym.management.Sessions;
import gym.customers.Instructor;

import gym.customers.Client;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The ThaiBoxing class represents a specific type of fitness session. It implements the Session interface.
 */
public class ThaiBoxing implements Session {
    private final int price = 100;
    private int quantity = 20;
    private Instructor instructor;
    private ForumType forumType;
    private String time;
    private ArrayList<Client> participants = new ArrayList<>();
    private final int finalQuantity = 20;
    /**
     * Constractor that initate time, forumtipe, and instractor of session.
     * @param s
     * @param forumType
     * @param i2
     */
    public ThaiBoxing(String s, ForumType forumType, Instructor i2){
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
     * Returns the current number of available spots.
     * @return
     */
    @Override
    public int getQuantity() {
        return this.quantity;
    }
    /**
     * Returns a string indicating the type of session.
     * @return
     */
    @Override
    public String getTypeString() {
        return "ThaiBoxing";
    }
    /**
     * Returns the forumType, which specifies the participant group
     * @return
     */
    @Override
    public ForumType getType() {
        return forumType;
    }
    /**
     * Returns the list of Client objects currently participating in the session.
     * @return
     */
    @Override
    public ArrayList<Client> getParticipants() {
        return this.participants;
    }
    /**
     * Returns the time string when the session is scheduled.
     * @return
     */
    @Override
    public String getTime(){
        return this.time;
    }
    /**
     * Converts the time string into a LocalDateTime object and returns it in a formatted string (e.g., "yyyy-MM-dd'T'HH:mm").
     * @return
     */
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
     * Returns the Instructor object associated with this session.
     * @return
     */
    @Override
    public Instructor getInstractor() {
        return this.instructor;
    }

    /**
     *Decreases the available spots by 1, if there are any spots available.
     */
    @Override
    public void setQuantityMinus() {
        if (quantity > 0) {
            this.quantity = this.quantity - 1;
        }
    }
    /**
     * Returns the maximum number of spots allowed in the session.
     * @return
     */
    @Override
    public int getFinalQuantity() {
        return this.finalQuantity;
    }
    /**
     * Adds a new message to the client's message list. This is part of the Member interface.
     * @param c
     * @param newMassage
     */
    @Override
    public void update(Client c, String newMassage) {
        c.getMassgaeArry().add(newMassage);
    }
}
