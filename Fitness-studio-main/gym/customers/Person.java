package gym.customers;

import gym.management.Bank;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * The Person class represents a person with basic attributes like name, gender, birth date, and bank account information. It also includes functionality for generating a unique ID, managing notifications (messages), and calculating the person's age based on their birth date.
 */
public class Person {
    private String name;
    private Gender gender;
    private String birthAge;
    private ArrayList<String> massage = new ArrayList<>();
    private static int ID = 1111;
    private int myId;
    private Bank bank;

    /**
     * Initializes a Person with the provided name, balance, gender, and birth date. A unique ID is assigned to the person, and a Bank object is created for them with the specified balance.
     * @param name
     * @param balance
     * @param g
     * @param bA
     */
    public Person(String name, int balance, Gender g, String bA){
        this.name = name;
        this.birthAge = bA;
        this.gender = g;
        setID();
        this.bank = new Bank(myId, balance);
    }

    /**
     * Initializes a Person with the provided name, balance, gender, birth date, and a specific ID. A Bank object is created using the provided ID and balance.
     * @param name
     * @param balance
     * @param g
     * @param bA
     * @param id
     */
    public Person(String name, int balance, Gender g, String bA, int id){
        this.name = name;
        this.birthAge = bA;
        this.gender = g;
        this.myId = id;
        this.bank = new Bank(myId, balance);
    }

    /**
     * Sets the unique ID for the Person. It assigns the current value of the static ID variable and increments it for the next Person created.
     */
    private void setID(){
        this.myId = this.ID;

        this.ID = this.ID + 1;
    }

    /**
     * Returns the name of the person.
     * @return
     */

    public String getName() {
        return this.name;
    }

    /**
     * Returns the birth date (age) of the person as a string.
     * @return
     */
    public String getBirthAge() {
        return this.birthAge;
    }

    /**
     * Returns the gender of the person.
     * @return
     */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Returns a string containing all the notifications (messages) associated with the person, formatted as a comma-separated list. If no messages are present, it returns "[]".
     * @return
     */

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

    /**
     * Returns the array list of messages (notifications) for the person.
     * @return
     */
        public ArrayList<String> getMassgaeArry () {
            return this.massage;
        }

    /**
     * Adds a new message (notification) to the list of messages for the person.
     * @param newMassage
     */
    public void update(String newMassage) {
        this.massage.add(newMassage);
    }

    /**\
     * Returns the unique ID of the person.
     * @return
     */

    public int getID(){
        return this.myId;
    }

    /**
     * Calculates and returns the person's age in years based on the given birth date (in the format "DD-MM-YYYY").
     * @param birthDate
     * @return
     */

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

    /**
     * Returns the Bank object associated with the person.
     * @return
     */
    public Bank getBank(){
        return this.bank;
    }

}
