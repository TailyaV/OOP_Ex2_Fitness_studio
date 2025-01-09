package gym.Exception;

/**
 * The InstructorNotQualifiedException class is a custom exception that extends the Exception class. It is used to handle situations where an instructor is not qualified to perform a certain action or task, such as teaching a session or course.
 */
public class InstructorNotQualifiedException extends Exception {

    public InstructorNotQualifiedException(String ms){
        super(ms);
    }
}
