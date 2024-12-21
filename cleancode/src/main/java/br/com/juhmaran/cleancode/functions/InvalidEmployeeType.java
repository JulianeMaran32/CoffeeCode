package br.com.juhmaran.cleancode.functions;

public class InvalidEmployeeType extends RuntimeException {

    public InvalidEmployeeType(String message) {
        super(message);
    }

}
