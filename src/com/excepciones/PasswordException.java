
package com.excepciones;

import java.io.Serializable;

/**
 *
 * @author FAMILIA P
 */
public class PasswordException extends Exception implements Serializable{

    public PasswordException(String message) {
        super(message);
    }

    
}
