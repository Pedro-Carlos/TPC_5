package e.exceptions;

public class ContactDoesNotExistException extends Exception {
    public ContactDoesNotExistException() {
        super("Contact does not exist.");
    }
}
