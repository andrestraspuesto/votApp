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
public class FueraDeFechaException extends Exception {

    /**
     * Creates a new instance of <code>FueraDeFechaException</code> without detail message.
     */
    public FueraDeFechaException() {
    }


    /**
     * Constructs an instance of <code>FueraDeFechaException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public FueraDeFechaException(String msg) {
        super(msg);
    }

    public FueraDeFechaException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
