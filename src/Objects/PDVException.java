/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Erick Cordero
 */
public class PDVException extends Exception {
    
     /**
     * Creates a new instance of <code>BibliotecaException</code> without detail
     * message.
     */
    public PDVException() {
    }

    
    public PDVException(String msg) {
        super(msg);
    }
    public PDVException(Throwable cause) 
    { 
        initCause(cause); 
    }
    public PDVException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }
    
}
