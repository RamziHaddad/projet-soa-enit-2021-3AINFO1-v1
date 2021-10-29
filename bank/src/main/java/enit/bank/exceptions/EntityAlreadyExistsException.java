package enit.bank.exceptions;

public class EntityAlreadyExistsException extends Exception {
    public EntityAlreadyExistsException(String msg) {
        super(msg);
    }
}
