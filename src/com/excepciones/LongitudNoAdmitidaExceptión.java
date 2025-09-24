
package com.excepciones;

import java.io.Serializable;

/**
 *
 * @author FAMILIA P
 */
public class LongitudNoAdmitidaExceptión extends Exception implements Serializable{

    public LongitudNoAdmitidaExceptión(String mensaje) {
        super(mensaje);
    }
    
}
