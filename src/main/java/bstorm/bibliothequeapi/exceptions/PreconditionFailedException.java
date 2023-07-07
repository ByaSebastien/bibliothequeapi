package bstorm.bibliothequeapi.exceptions;

import lombok.Getter;

public class PreconditionFailedException extends RuntimeException{

    public PreconditionFailedException(){

        super("Error");
    }

    public PreconditionFailedException(String message){

        super(message);
    }
}
