
package com.excepciones;

import java.io.Serializable;

/**
 *
 * @author FAMILIA P
 */
public class CorreoException extends Exception implements Serializable{

    public CorreoException(String mensaje) {
        super(mensaje);
    }
    
}
