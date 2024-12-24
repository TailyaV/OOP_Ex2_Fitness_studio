package gym.customers;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;

import java.util.ArrayList;

public class Instructor extends Person {
    private int hourPay;
    private ArrayList<SessionType> sessionTypesArry;
    public Instructor(String name, int balance, Gender g, String bA) {
        super(name, balance, g, bA);
    }

    public Instructor(Person p4, int i, ArrayList<SessionType> objects){
        super(p4.getName(), p4.getBank().getBalance() ,p4.getGender(), p4.getBirthAge(), p4.getID());
        this.hourPay = i;
        this.sessionTypesArry = objects;
    }
    public int getHourPay(){
        return this.hourPay;
    }

    public ArrayList<SessionType> getSessionQualify(){
        return this.sessionTypesArry;
    }

    public String toStringArr(ArrayList<SessionType> sessionQualify){
        if(!sessionQualify.isEmpty()) {
            String sArr = sessionQualify.get(0).toString();
            for (int i = 1; i < sessionQualify.size();  i = i + 1) {
                sArr = sArr + ", " + sessionQualify.get(i);
            }
            return sArr;
        }
        return null;
    }
}
