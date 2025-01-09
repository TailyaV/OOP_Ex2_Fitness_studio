package gym.management.Sessions;
import gym.customers.Instructor;

/**
 * The SessionFactory class is a utility class responsible for creating different types of Session objects based on the session type provided. It uses the Factory design pattern to centralize the creation logic for various session types.
 */
public class SessionFactory {
    public static Session createSession (SessionType sessionType, String s, ForumType forumType, Instructor i2){
        switch (sessionType){
            case Ninja:
                return new Ninja(s, forumType, i2);
            case Pilates:
                return new Pilates(s, forumType, i2);
            case ThaiBoxing:
                return new ThaiBoxing(s, forumType, i2);
            case MachinePilates:
                return  new MachinePilates(s, forumType, i2);
            default:
                throw new IllegalArgumentException("Eror: Not exsist session");

        }

    }
}
