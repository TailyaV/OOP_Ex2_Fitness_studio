package gym.management.Sessions;
import gym.customers.Instructor;

import gym.customers.Client;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ThaiBoxing implements Session {
    private final int price = 100;
    private int quantity = 20;
    private Instructor instructor;
    private ForumType forumType;
    private String time;
    private ArrayList<Client> participants = new ArrayList<>();
    private final int finalQuantity = 20;

    public ThaiBoxing(String s, ForumType forumType, Instructor i2){
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
    public String getTypeString() {
        return "ThaiBoxing";
    }

    @Override
    public ForumType getType() {
        return forumType;
    }

    @Override
    public ArrayList<Client> getParticipants() {
        return this.participants;
    }

    @Override
    public String getTime(){
        return this.time;
    }

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
    public Instructor getInstractor() {
        return this.instructor;
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
    public void update(Client c, String newMassage) {
        c.getMassgaeArry().add(newMassage);
    }
}
