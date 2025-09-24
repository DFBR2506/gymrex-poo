
package com.excepciones;

import java.io.Serializable;

/**
 *
 * @author Estudiantes
 */
public class PinCaracteresException extends Exception implements Serializable{

    public PinCaracteresException(String message) {
        super(message);
    }
 
}
