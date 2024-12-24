package gym.management.Sessions;

import gym.customers.Client;
import gym.customers.Instructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MachinePilates implements Session {
    private final int price = 80;
    private final int finalQuantity = 10;
    private int quantity = 10;
    private Instructor instructor;
    private ForumType forumType;
    private String time;
    private ArrayList<Client> participants = new ArrayList<>();

    public MachinePilates(String s, ForumType forumType, Instructor i2){
        this.time = s;
        this.forumType = forumType;
        this.instructor = i2;
    }
    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public ForumType getType() {
        return forumType;
    }

    @Override
    public String getTypeString() {
        return "MachinePilates";
    }

    @Override
    public ArrayList<Client> getParticipants() {
        return this.participants;
    }

    @Override
    public String getTime(){
        return this.time;
    }
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

    @Override
    public void update(Client c, String newMassage) {
        c.getMassgaeArry().add(newMassage);
    }
    @Override
    public void setQuantityPlus() {
        if(quantity < finalQuantity) {
            this.quantity = this.quantity + 1;
        }
    }

    @Override
    public void setQuantityMinus() {
        if (quantity > 0) {
            this.quantity = this.quantity - 1;
        }
    }
    @Override
    public int getFinalQuantity() {
        return this.finalQuantity;
    }

    @Override
    public Instructor getInstractor() {
        return this.instructor;
    }

}
