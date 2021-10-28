
package com.googlecode.gmail4j;


public class GmailException extends RuntimeException {

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = -2919776925807264765L;

    /**
     * Constructor with error message
     * 
     * @param message Error message
     */
    public GmailException(final String message) {
        super(message);
    }
    
    /**
     * Constructor with error message and cause
     * 
     * @param message Error message
     * @param cause Cause
     */
    public GmailException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
