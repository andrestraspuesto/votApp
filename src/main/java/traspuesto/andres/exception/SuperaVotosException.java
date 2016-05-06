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
public class SuperaVotosException extends Exception {

    /**
     * Creates a new instance of <code>NewException</code> without detail message.
     */
    public SuperaVotosException() {
    }


    /**
     * Constructs an instance of <code>NewException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SuperaVotosException(String msg) {
        super(msg);
    }

    public SuperaVotosException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
