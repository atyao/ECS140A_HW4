public class UsingIteratorPastEndException extends Exception { // Extends Exception means Checked
    // To avoid warnings from javac
    static final long serialVersionUID = 98L;
    // Pass along the error message
    public UsingIteratorPastEndException(String message) {
        super(message);
    }
}