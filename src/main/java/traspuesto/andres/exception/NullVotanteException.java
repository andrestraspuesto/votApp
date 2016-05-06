/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package traspuesto.andres.exception;

/**
 *
 * @author andrestraspuesto@gmail.com
 */
public class NullVotanteException extends Exception {

    /**
     * Creates a new instance of <code>NullVotanteException</code> without detail message.
     */
    public NullVotanteException() {
    }


    /**
     * Constructs an instance of <code>NullVotanteException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NullVotanteException(String msg) {
        super(msg);
    }

    public NullVotanteException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
