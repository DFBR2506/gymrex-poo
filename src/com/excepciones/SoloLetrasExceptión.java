
package com.excepciones;

import java.io.Serializable;

/**
 *
 * @author FAMILIA P
 */
public class SoloLetrasExceptión extends Exception implements Serializable{

    public SoloLetrasExceptión(String mensaje) {
        super(mensaje);
    }
    
}
