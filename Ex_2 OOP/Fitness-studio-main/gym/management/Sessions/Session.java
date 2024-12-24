package gym.management.Sessions;

import gym.customers.Client;
import gym.customers.Instructor;

import java.util.ArrayList;

public interface Session extends Member {

   // management.Sessions.ForumType getForumType();

    int getPrice();

    int getQuantity();
    String getTypeString();
    ForumType getType();
    ArrayList<Client> getParticipants();
    String getTime();
    void setQuantityPlus();
    void setQuantityMinus();
    int getFinalQuantity();
    String getFormatTime();
    Instructor getInstractor();
}
