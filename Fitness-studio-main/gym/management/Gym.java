package gym.management;
import gym.customers.Client;
import gym.customers.Instructor;
import gym.customers.Person;
import gym.management.Sessions.Session;

import java.util.ArrayList;

/**
 * The Gym class is a singleton class that encapsulates the structure and operations of a gym, including its bank, employees (secretary and instructors), clients, and available sessions. It ensures that only one instance of the Gym exists through the singleton pattern.
 */
public class Gym {
    private static Gym instance;
    private String name;
    private  Secretary gymSecretary;
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Instructor> instructors = new ArrayList<>();
    private ArrayList<Session> sessionsArry = new ArrayList<>();
    private Bank bank;
    ArrayList<String> actionHistory = new ArrayList<>();

    /**
     * Private constractor for singelton, initial a new bank account.
     */
    private Gym(){
        this.bank = new Bank(0000, 0);
    }

    /**
     * This method provides a detailed textual representation of the gym.
     * @return
     */
    @Override
    public String toString(){
        String gymName = "Gym Name: " + Gym.getInstance().name;
        String gymSecratory = "Gym Secretary: ID: " + this.gymSecretary.getID() + " | Name: " + this.gymSecretary.getName() + " | Gender: " + this.gymSecretary.getGender() + " | Birthday: " + this.gymSecretary.getBirthAge() + " | Age: " + this.gymSecretary.getAge(this.gymSecretary.getBirthAge()) + " | Balance: " + this.gymSecretary.getBank().getBalance() + " | Role: Secretary | Salary per Month: " + this.gymSecretary.getSalary();
        String gymBalance = "Gym Balance: " + this.bank.getBalance();
        String clientsData = "Clients Data:";
        for(Client c : this.clients){
            clientsData = clientsData + "\nID: " + c.getID() + " | Name: " + c.getName() + " | Gender: " + c.getGender() + " | Birthday: " + c.getBirthAge() + " | Age: " + c.getAge(c.getBirthAge()) + " | Balance: " + c.getBank().getBalance();
        }
        String employeesData = "Employees Data:";
        for(Instructor i : instructors){
            employeesData = employeesData + "\nID: " + i.getID() + " | Name: " + i.getName() + " | Gender: " + i.getGender() + " | Birthday: " + i.getBirthAge() + " | Age: " + i.getAge(i.getBirthAge()) + " | Balance: " + i.getBank().getBalance() + " | Role: Instructor | Salary per Hour: " + i.getHourPay() + " | Certified Classes: " + i.toStringArr(i.getSessionQualify());
        }
        employeesData = employeesData + "\nID: " + this.gymSecretary.getID() + " | Name: " + this.gymSecretary.getName() + " | Gender: " + this.gymSecretary.getGender() + " | Birthday: " + this.gymSecretary.getBirthAge() + " | Age: " + this.gymSecretary.getAge(this.gymSecretary.getBirthAge()) + " | Balance: " + this.gymSecretary.getBank().getBalance() + " | Role: Secretary | Salary per Month: " + this.gymSecretary.getSalary();
        String sessionData = "Sessions Data:";
        for(Session s : sessionsArry){
            sessionData = sessionData + "\nSession Type: " + s.getTypeString() + " | Date: " + s.getTime() + " | Forum: " + s.getType().toString() + " | Instructor: "  + s.getInstractor().getName() + " | Participants: " + s.getParticipants().size() + "/" + s.getFinalQuantity();
        }
        String finalString = gymName + "\n" + gymSecratory + "\n" + gymBalance + "\n\n" + clientsData + "\n\n" + employeesData + "\n\n" + sessionData;
        return finalString;
    }

    /**
     * If a gym excist the metod return it, if not it create a new one.
     * @return
     */
    public static Gym getInstance() {
        if (instance == null){
           instance = new Gym();
        }
        return instance;
    }

    /**
     * Set the gym name.
     * @param crossFit
     */
    public void setName(String crossFit) {
        this.name = crossFit;
    }

    /**
     * Set a new secratory to the gym.
     * @param p1
     * @param i
     */
    public void setSecretary(Person p1, int i) {
        this.gymSecretary = new Secretary(p1, i);
        this.actionHistory.add("A new secretary has started working at the gym: " + p1.getName());
    }

    /**
     * Return the gym secratory.
     * @return
     */
    public Secretary getSecretary() {
        return gymSecretary;
    }

    /**
     * Returns a list of the gym's clients.
     * @return
     */
    protected ArrayList<Client> getClients(){
        return this.clients;
    }

    /**
     * Returns a list of the gym's instructors.
     * @return
     */
    protected ArrayList<Instructor> getInstructors(){
        return this.instructors;
    }

    /**
     * Returns a list of the gym's available sessions
     * @return
     */
    protected ArrayList<Session> getSessionsArry(){
        return this.sessionsArry;
    }

    /**
     * Return the gym's bank.
     * @return
     */
    protected Bank getBank(){
        return this.bank;
    }
}
