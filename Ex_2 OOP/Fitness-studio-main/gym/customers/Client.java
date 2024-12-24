package gym.customers;

import gym.management.Sessions.ForumType;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Client extends Person {
    private ArrayList<ForumType> arrOfForumTipe = new ArrayList<>();

    public Client(String name, int balance, Gender g, String bA) {
        super(name, balance, g, bA);

    }
   public Client(Person p){
        super(p.getName(), p.getBank().getBalance(), p.getGender(), p.getBirthAge(), p.getID());
        arrOfForumTipe.addAll(this.listOfAvailableForum());
   }

    public Boolean isEqual(Client a){
        return a.getName().equals(this.getName()) && a.getBank().getBalance() == this.getBank().getBalance() && a.getBirthAge().equals(this.getBirthAge()) && a.getGender() == this.getGender();
    }

    public Boolean isContain(ArrayList<Client> arr){
        if(arr != null) {
            for (Client c : arr) {
                if (this.isEqual(c)) {
                    return true;
                }
            }
        }
        return false;
    }


    public ArrayList<ForumType> listOfAvailableForum (){
        ArrayList<ForumType> arr = new ArrayList<>();
        arr.add(ForumType.All);
        if(this.getAge(this.getBirthAge()) >= 65){
            arr.add(ForumType.Seniors);
        }
        if(this.getGender() == Gender.Male){
            arr.add(ForumType.Male);
        }
        else {
            arr.add(ForumType.Female);
        }
        return arr;
    }

}
