package ku.shop;

public class NotEnoughException extends RuntimeException{
    public NotEnoughException(String errorMessage) {
        super(errorMessage);
    }
}
