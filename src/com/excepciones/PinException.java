
package com.excepciones;

import java.io.Serializable;

/**
 *
 * @author FAMILIA P
 */
public class PinException extends Exception implements Serializable{

    public PinException(String message) {
        super(message);
    }

    
    
}
