package nl.cms.view;

import java.util.List;

/**
 * Helper model that is used to encapsulate an errormessage along with an optional list of errors.
 */
public class ErrorMessage {

    public final String message;
    public final List<String> errors;

    public ErrorMessage(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public static ErrorMessage of(String message) {
        return new ErrorMessage(message, null);
    }

    public static ErrorMessage of(String message, List<String> errors) {
        return new ErrorMessage(message, errors);
    }
}
