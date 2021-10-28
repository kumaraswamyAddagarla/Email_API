
package com.googlecode.gmail4j;

import com.googlecode.gmail4j.auth.Credentials;


public class GmailConnection {

    /**
     * Login credentials
     */
    protected Credentials loginCredentials;  
    
    /**
     * Argless constructor. 
     * <p>
     * You have to set {@link #loginCredentials} afterwards.
     * 
     * @see #setLoginCredentials(Credentials)
     * @see #setLoginCredentials(String, char[])
     */
    public GmailConnection() {
        //nothing to do
    }
    
    /**
     * Constructor that sets {@link #loginCredentials}
     * 
     * @param loginCredentials Gmail login credentials
     * @throws GmailException if credentials are not provided
     */
    public GmailConnection(final Credentials loginCredentials) {
        loginCredentials.validate();
        this.loginCredentials = loginCredentials;
    }
    
    /**
     * Convenience constructor that sets {@link #loginCredentials}
     * 
     * @param username Gmail username
     * @param password Gmail password
     * @throws GmailException if credentials are not provided
     */
    public GmailConnection(final String username, final char[] password) {
        this(new Credentials(username, password));
    }
    
    /**
     * Setter for {@link #loginCredentials}
     * 
     * @param loginCredentials Gmail login
     * @throws GmailException if provided {@link Credentials} are invalid
     */
    public void setLoginCredentials(final Credentials loginCredentials) {
        loginCredentials.validate();
        this.loginCredentials = loginCredentials;
    }

    /**
     * Wrapper method for setting {@link #loginCredentials}
     * 
     * @param username Gmail username
     * @param password Gmail password
     * @throws GmailException if provided {@link Credentials} are invalid
     */
    public void setLoginCredentials(final String username, 
            final char[] password) {
        setLoginCredentials(new Credentials(username, password));
    }
    
    /**
     * Disconnects from Gmail
     */
    public void disconnect() {    	
    }
}
