package gym.management.Sessions;

import gym.customers.Client;

/**
 * The Member interface defines a contract for any class that needs to implement a method for updating a client's message.
 */
public interface Member {
    /**
     *  and a String message (newMassage) as parameters. The method is intended to update the client’s message.
     * @param c
     * @param newMassage
     */
    void update(Client c, String newMassage);
}
