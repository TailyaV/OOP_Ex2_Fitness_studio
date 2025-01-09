package gym.customers;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;

import java.util.ArrayList;

/**
 * The Instructor class extends the Person class and represents an instructor in the system. It includes additional attributes related to the instructor's pay rate and session qualifications.
 */
public class Instructor extends Person {
    private int hourPay;

    /**
     * Initializes the Instructor object using the constructor of the Person class, providing the instructor's name, balance, gender, and birth year.
     */
    private ArrayList<SessionType> sessionTypesArry;
    public Instructor(String name, int balance, Gender g, String bA) {
        super(name, balance, g, bA);
    }

    /**
     * Creates an Instructor object by copying the data from an existing Person object and setting the instructor's hourly pay (hourPay) and the list of session types they are qualified to teach (sessionTypesArry).
     * @param p4
     * @param i
     * @param objects
     */
    public Instructor(Person p4, int i, ArrayList<SessionType> objects){
        super(p4.getName(), p4.getBank().getBalance() ,p4.getGender(), p4.getBirthAge(), p4.getID());
        this.hourPay = i;
        this.sessionTypesArry = objects;
    }

    /**
     * Returns the hourly pay rate (hourPay) of the instructor.
     * @return
     */
    public int getHourPay(){
        return this.hourPay;
    }

    /**
     * Returns the list of session types (sessionTypesArry) that the instructor is qualified to teach.
     * @return
     */

    public ArrayList<SessionType> getSessionQualify(){
        return this.sessionTypesArry;
    }

    /**
     * Converts the list of session types (sessionQualify) into a comma-separated string. If the list is empty, it returns null.
     * @param sessionQualify
     * @return
     */

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
