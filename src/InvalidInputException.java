/**
 * Custom exception to throw when user doesn't enter one of the expected inputs
 *
 * @author Bhavyai Gupta
 */
public class InvalidInputException extends Exception {
    public InvalidInputException(String errorMessage) {
        super(errorMessage);
    }
}
