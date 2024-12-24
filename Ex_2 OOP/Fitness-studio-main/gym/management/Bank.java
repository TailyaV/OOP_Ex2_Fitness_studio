package gym.management;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private int ID;
    private static Map<Integer, Integer> bankAccounts = new HashMap<>();
    public Bank(int id, int balance){
            if (bankAccounts.containsKey(id)) {
                this.ID = id;
        }
        else {
                this.ID = id;
                bankAccounts.put(id, balance);
            }
    }

    public void raiseBalance(int price){
        bankAccounts.put(this.ID, bankAccounts.get(this.ID) + price);
    }
    public void reduceBalance(int price){
        bankAccounts.put(this.ID, bankAccounts.get(this.ID) - price);

    }
    public int getBalance(){
        return bankAccounts.get(this.ID);
    }
}
