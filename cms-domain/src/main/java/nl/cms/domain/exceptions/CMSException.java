package nl.cms.domain.exceptions;

public class CMSException extends RuntimeException {
    public CMSException(String error) {
        super(error);
    }

    public CMSException(String error, Throwable throwable) {
        super(error, throwable);
    }
}
