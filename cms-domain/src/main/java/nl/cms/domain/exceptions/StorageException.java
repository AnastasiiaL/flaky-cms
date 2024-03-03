package nl.cms.domain.exceptions;

public class StorageException extends CMSException {

    public StorageException(Throwable throwable) {
        super("Failed to store data: " + throwable.getMessage(), throwable);
    }
}
