
package com.excepciones;

import java.io.Serializable;

/**
 *
 * @author FAMILIA P
 */
public class EmptyFieldException extends Exception implements Serializable{

    public EmptyFieldException(String mensaje) {
        super(mensaje);
    }
    
}
