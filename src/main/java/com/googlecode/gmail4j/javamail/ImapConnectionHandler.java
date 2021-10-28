
package com.googlecode.gmail4j.javamail;

import javax.mail.event.ConnectionAdapter;
import javax.mail.event.ConnectionEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ImapConnectionHandler extends ConnectionAdapter {

    /**
    * Logger
    */
    private static final Log LOG = LogFactory.getLog(ImapConnectionHandler.class);
    /**
     * Contain information of current connection service{@link ConnectionInfo}.
     *
     * @see #ConnectionInfo(String user, String host, int port)
     */
    private final ConnectionInfo connectionInfo;
    /**
     * Holds the current connection service start time in milli seconds.
     */
    private long startTime;

    /**
     * Constructor with ConnectionInfo object
     *
     * @param connectionInfo ConnectionInfo object
     */
    public ImapConnectionHandler(ConnectionInfo connectionInfo) {
        this.connectionInfo = connectionInfo;
    }

    @Override
    public void opened(ConnectionEvent e) {
        if (LOG.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOG.debug("ImapGmailConnection " + connectionInfo + "is opened.");
        }
    }

    @Override
    public void closed(ConnectionEvent e) {
        if (LOG.isDebugEnabled()) {
            long upTime = (System.currentTimeMillis() - startTime) / 1000;
            LOG.debug("ImapGmailConnection " + connectionInfo 
                    + "is closed after " + upTime + " seconds.");
        }
    }

    @Override
    public void disconnected(ConnectionEvent e) {
        if (LOG.isDebugEnabled()) {
            long upTime = (System.currentTimeMillis() - startTime) / 1000;
            LOG.debug("ImapGmailConnection " + connectionInfo 
                    + "has been disconnectedafter " + upTime + " seconds.");
        }
    }
}