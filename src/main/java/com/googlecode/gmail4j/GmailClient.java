
package com.googlecode.gmail4j;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public abstract class GmailClient {
    /**
     * Logger
     */
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * Strategies to fetch emails with
     */
    public enum EmailSearchStrategy {
        SUBJECT(), DATE_GT(), DATE_LT(), DATE_EQ, TO(), FROM(), KEYWORD(), CC(), UNREAD();
    };

    /**
     * Gmail Connection 
     * 
     * @see #setConnection(GmailConnection)
     */
    protected GmailConnection connection;  
    
    /**
     * Argless constructor for safe extending 
     */
    public GmailClient() {
        super();
    }
    
    /**
     * Sets Gmail #connection 
     * 
     * @param connection Gmail connection
     */
    public void setConnection(final GmailConnection connection) {
        this.connection = connection;
    }
    
    /**
     * Returns list of unread {@link GmailMessage} objects
     * 
     * @return List of unread messages
     */
    public abstract List<GmailMessage> getUnreadMessages();

    /**
     * Returns list of matching {@link GmailMessage} objects
     *
     * @param strategy search strategy
     * @param value the value to look for
     */
    public abstract GmailMessageList getMessagesBy(EmailSearchStrategy strategy, String value);
    
    /**
     * Sends the message
     * 
     * @param message Message to be sent
     */
    public abstract void send(final GmailMessage message);
    
    /**
     * Disconnects from Gmail
     */
    public abstract void disconnect();
}