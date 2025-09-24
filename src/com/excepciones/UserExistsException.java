
package com.excepciones;

import java.io.Serializable;

/**
 *
 * @author FAMILIA P
 */
public class UserExistsException extends Exception implements Serializable{

    public UserExistsException(String mensaje) {
        super(mensaje);
    }
    
}
