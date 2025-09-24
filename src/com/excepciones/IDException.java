package com.excepciones;

import java.io.Serializable;

/**
 *
 * @author FAMILIA P
 */
public class IDException extends Exception implements Serializable{

    public IDException(String message) {
        super(message);
    }

}
