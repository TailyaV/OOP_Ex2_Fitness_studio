package gym.customers;

import gym.management.Bank;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Person {
    private String name;
    private Gender gender;
    private String birthAge;
    private ArrayList<String> massage = new ArrayList<>();
    private static int ID = 1111;
    private int myId;
    private Bank bank;

    public Person(String name, int balance, Gender g, String bA){
        this.name = name;
        this.birthAge = bA;
        this.gender = g;
        setID();
        this.bank = new Bank(myId, balance);
    }
    public Person(String name, int balance, Gender g, String bA, int id){
        this.name = name;
        this.birthAge = bA;
        this.gender = g;
        this.myId = id;
        this.bank = new Bank(myId, balance);
    }

    public void setID(){
        this.myId = this.ID;

        this.ID = this.ID + 1;
    }

    public String getName() {
        return this.name;
    }
    public String getBirthAge() {
        return this.birthAge;
    }
    public Gender getGender() {
        return this.gender;
    }

    public String getNotifications() {
        if (!this.massage.isEmpty()) {
            String notification = "";
            notification = notification + this.massage.get(0);
            for (int i = 1; i < this.massage.size(); i = i + 1){
                notification = notification + ", " + this.massage.get(i) ;
            }
            return "[" + notification + "]";
        }
        else {
            return "[]";
        }
    }
        public ArrayList<String> getMassgaeArry () {
            return this.massage;
        }

    public void update(String newMassage) {
        this.massage.add(newMassage);
    }

    public int getID(){
        return this.myId;
    }

    public int getAge(String birthDate){
        LocalDate currentDate = LocalDate.now();
        String[] bA = birthDate.split("-");
        int day = Integer.parseInt(bA[0]);
        int month = Integer.parseInt(bA[1]);
        int year = Integer.parseInt(bA[2]);
        LocalDate personDate = LocalDate.of(year, month, day);
        Period age = Period.between(personDate, currentDate);
        return age.getYears();
    }
    public Bank getBank(){
        return this.bank;
    }

}
