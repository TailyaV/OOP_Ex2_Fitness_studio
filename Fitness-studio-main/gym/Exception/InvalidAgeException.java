package gym.Exception;

/**
 * The InvalidAgeException class is a custom exception that extends the Exception class. It is used to handle cases where an invalid age value is encountered, such as when a person's age is out of a valid range or doesn't meet specific requirements.
 */
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String massage){
        super(massage);
    }
}
