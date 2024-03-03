package nl.cms.domain.exceptions;

public class IllegalLayerException extends CMSException {

    public IllegalLayerException() {
        super("Unknown revision number");
    }
}
