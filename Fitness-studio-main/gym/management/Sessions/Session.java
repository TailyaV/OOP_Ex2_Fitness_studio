package gym.management.Sessions;

import gym.customers.Client;
import gym.customers.Instructor;

import java.util.ArrayList;

/**
 * The Session interface extends the Member interface and defines the structure and behavior for different types of sessions that clients can participate in.
 */
public interface Session extends Member {

   // management.Sessions.ForumType getForumType();

    /**
     * Returns the price of the session
     * @return
     */
    int getPrice();

    /**
     * Returns the current number of available spots in the session.
     * @return
     */
    int getQuantity();

    /**
     * Returns a string representing the type of session
     * @return
     */
    String getTypeString();

    /**
     * Returns the type of session using the ForumType enum
     * @return
     */
    ForumType getType();

    /**
     * Returns an array list of Client objects who are registered for the session.
     * @return
     */
    ArrayList<Client> getParticipants();

    /**
     * Returns the scheduled time for the session as a String.
     * @return
     */
    String getTime();

    /**
     * Decreases the number of available spots for the session by 1, if there are any spots available.
     */
    void setQuantityMinus();

    /**
     * Returns the maximum number of spots allowed in the session.
     * @return
     */
    int getFinalQuantity();

    /**
     *  Converts and formats the session's time into a standardized format ("yyyy-MM-dd'T'HH:mm").
     * @return
     */
    String getFormatTime();

    /**
     * Returns the Instructor object associated with the session.
     * @return
     */
    Instructor getInstractor();
}
