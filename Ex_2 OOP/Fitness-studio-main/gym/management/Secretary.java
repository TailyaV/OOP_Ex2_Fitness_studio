package gym.management;
import gym.customers.*;
import gym.Exception.*;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionFactory;
import gym.management.Sessions.SessionType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;

public class Secretary extends Person{
    private int salary;

    protected Secretary(Person p , int salary){
        super(p.getName(), p.getBank().getBalance(), p.getGender(), p.getBirthAge(), p.getID());
        this.salary = salary;
    }

    public int getSalary(){
        return this.salary;
    }

    public Client registerClient(Person p2) throws InvalidAgeException, DuplicateClientException {
        if (this != Gym.getInstance().getSecretary()) {
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        }
        Client c = new Client(p2);
       if(c.getAge(p2.getBirthAge()) < 18) {
           throw new InvalidAgeException("Error: Client must be at least 18 years old to register") ;
       }
       if(c.isContain(Gym.getInstance().getClients())){
           throw new DuplicateClientException("Error: The client is already registered");
       }
        Gym.getInstance().getClients().add(c);
       Gym.getInstance().actionHistory.add("Registered new client: " + p2.getName());
       return c;
    }

    public void unregisterClient(Client c2) throws ClientNotRegisteredException {
        if (this != Gym.getInstance().getSecretary()) {
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        }
        if(c2.isContain(Gym.getInstance().getClients())){
            Gym.getInstance().getClients().remove(c2);
            Gym.getInstance().actionHistory.add("Unregistered client: " + c2.getName());
        }
        else
            throw new ClientNotRegisteredException("Error: Registration is required before attempting to unregister");
    }

    public Instructor hireInstructor(Person p4, int i, ArrayList<SessionType> objects) {
        if (this != Gym.getInstance().getSecretary()) {
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        }
        Instructor instructor = new Instructor(p4, i, objects);
        Gym.getInstance().getInstructors().add(instructor);
        Gym.getInstance().actionHistory.add("Hired new instructor: " + instructor.getName() + " with salary per hour: " + instructor.getHourPay());
        return instructor;
    }

    public void registerClientToLesson(Client c1, Session s1) throws DuplicateClientException, ClientNotRegisteredException, NullPointerException {
        if (this != Gym.getInstance().getSecretary()) {
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        }
        if (!c1.isContain(Gym.getInstance().getClients())) {
            throw new ClientNotRegisteredException("Error: The client is not registered with the gym and cannot enroll in lessons");
        }
        if (c1.getBank().getBalance() >= s1.getPrice() && isForumContain(c1.listOfAvailableForum(), s1.getType()) && s1.getQuantity() > 0 && s1.getQuantity() <= s1.getFinalQuantity() && isTimePast(s1.getTime())) {

            if (c1.isContain(s1.getParticipants())) {
                throw new DuplicateClientException("Error: The client is already registered for this lesson");
            }
            //זמן השיעור טרם חלף.
            s1.getParticipants().add(c1);
            s1.setQuantityMinus();
            c1.getBank().reduceBalance(s1.getPrice());
            Gym.getInstance().getBank().raiseBalance(s1.getPrice());
            Gym.getInstance().actionHistory.add("Registered client: " + c1.getName() + " to session: " + s1.getTypeString() + " on " + s1.getFormatTime() + " for price: " + s1.getPrice());
        } else {
            chackFail(c1, s1);
        }
    }
    private void chackFail(Client c1, Session s1){
        if(!isTimePast(s1.getTime())){
            Gym.getInstance().actionHistory.add("Failed registration: Session is not in the future");
        }
        if(!isForumContain(c1.listOfAvailableForum(), s1.getType())){
            //איך עודים כללי יותר ולא רק ספציפי לסניור?
            if(c1.getAge(c1.getBirthAge()) < 65 && s1.getType().toString() == "Seniors") {
                Gym.getInstance().actionHistory.add("Failed registration: Client doesn't meet the age requirements for this session (Seniors)");
            }
            else if(!c1.getGender().toString().equals(s1.getType().toString())) {
                Gym.getInstance().actionHistory.add("Failed registration: Client's gender doesn't match the session's gender requirements");
            }
        }
        if(c1.getBank().getBalance() < s1.getPrice()){
            Gym.getInstance().actionHistory.add("Failed registration: Client doesn't have enough balance");
        }
        if(s1.getQuantity() <= 0){
            Gym.getInstance().actionHistory.add("Failed registration: No available spots for session");
        }

    }

    public void paySalaries() {
        if (this != Gym.getInstance().getSecretary()) {
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        }
        for(Session s : Gym.getInstance().getSessionsArry()){
            s.getInstractor().getBank().raiseBalance(s.getInstractor().getHourPay());
            Gym.getInstance().getBank().reduceBalance(s.getInstractor().getHourPay());
        }
        this.getBank().raiseBalance(this.salary);
        Gym.getInstance().getBank().reduceBalance(this.salary);
        Gym.getInstance().actionHistory.add("Salaries have been paid to all employees");
    }

    public void printActions() {
        if (this != Gym.getInstance().getSecretary()) {
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        }
        for(String s : Gym.getInstance().actionHistory){
            System.out.println(s);
        }
    }

    public Session addSession(SessionType sessionType, String s, ForumType forumType, Instructor i2) throws InstructorNotQualifiedException {
        if (this != Gym.getInstance().getSecretary()) {
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        }
        if (!isSessContain(i2.getSessionQualify(), sessionType)) {
            throw new InstructorNotQualifiedException("Error: Instructor is not qualified to conduct this session type.");
        } else {
            Session session = SessionFactory.createSession(sessionType, s, forumType, i2);
            Gym.getInstance().getSessionsArry().add(session);
            Gym.getInstance().actionHistory.add("Created new session: "  + session.getTypeString() + " on " + session.getFormatTime() + " with instructor: " + i2.getName());
            return session;
        }
    }

    private Boolean isSessContain(ArrayList<SessionType> arr, SessionType s){
        Boolean f = false;
        for (SessionType st : arr) {
            if (st == s) {
                f = true;
                break;
            }
        }
        return f;
    }

    public void notify(String newMassage) {
        if (this != Gym.getInstance().getSecretary()) {
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        }
        for (Client c : Gym.getInstance().getClients()) {
            c.update(newMassage);
        }
        Gym.getInstance().actionHistory.add("A message was sent to all gym clients: " + newMassage);
    }

    public void notify(Session s, String newMassage) {
        if (this != Gym.getInstance().getSecretary()) {
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        }
        for (Client c : s.getParticipants()) {
            s.update(c ,newMassage);
        }
        Gym.getInstance().actionHistory.add("A message was sent to everyone registered for session " + s.getTypeString() + " on " + s.getFormatTime() + " : " + newMassage);
    }

    public void notify(String date, String newMassage) {
        if (this != Gym.getInstance().getSecretary()) {
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        }
        ArrayList<Session> relevantSession = new ArrayList<>();
        for (Session s : Gym.getInstance().getSessionsArry()) {
            String[] time = s.getTime().split(" ");

           if(time[0].equals(date)){
               relevantSession.add(s);
           }
        }
        for(Session s : relevantSession){
            for (Client c : s.getParticipants()) {
                s.update(c, newMassage);
            }
        }
            String[] yearMonthDay = date.split("-");
            String goodDate = yearMonthDay[2] + "-"+yearMonthDay[1] + "-" + yearMonthDay[0];
            Gym.getInstance().actionHistory.add("A message was sent to everyone registered for a session on " + goodDate + " : " + newMassage);
    }

    public Boolean isForumContain(ArrayList<ForumType> arr, ForumType ft){
        if(arr != null) {
            for (ForumType f : arr) {
                if(f == ft){
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean isTimePast(String sessionTime) {
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        String[] yearAndHour = sessionTime.split(" ");
        String[] hourAndMinute = yearAndHour[1].split(":");
        int hour = Integer.parseInt(hourAndMinute[0]);
        int minute = Integer.parseInt(hourAndMinute[1]);
        LocalTime sTime = LocalTime.of(hour, minute);
        String[] bA = yearAndHour[0].split("-");
        int day = Integer.parseInt(bA[0]);
        int month = Integer.parseInt(bA[1]);
        int year = Integer.parseInt(bA[2]);
        LocalDate sessionDate = LocalDate.of(year, month, day);
        Period pastTime = Period.between(currentDate, sessionDate);
        if (pastTime.isNegative() && sTime.isBefore(currentTime)) {
            return false;
        }
        return true;
    }
}
