package stuba.tomas.kostrna.oop.backend;

public class Response {

    public boolean wrongLogInfo() {
        System.out.println("Username or password is bad");
        return false;
    }

    public boolean logInSuccessful() {
        System.out.println("login successful");
        return true;
    }

}
