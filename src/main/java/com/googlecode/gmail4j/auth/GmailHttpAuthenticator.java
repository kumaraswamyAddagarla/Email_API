
package com.googlecode.gmail4j.auth;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.Proxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.gmail4j.GmailConnection;


public class GmailHttpAuthenticator extends Authenticator {
    
    /**
     * Logger
     */
    private static final Log log = LogFactory.getLog(GmailHttpAuthenticator.class);
    
    /**
     * Credentials given as response to <a href="http://mail.google.com">
     * mail.google.com</a> server request.
     */
    private final Credentials credentials;
    
    /**
     * Credentials given as response to {@link Proxy} authentication request.
     */
    private Credentials proxyCredentials;
    
    /**
     * Constructor that sets {@link #credentials}
     * 
     * @param credentials Gmail login
     */
    public GmailHttpAuthenticator(final Credentials credentials) {
        this.credentials = credentials;
    }
    
    /**
     * Constructor that sets {@link #credentials} and {@link #proxyCredentials}
     * 
     * @param credentials Gmail login
     * @param proxyCredentials Proxy authentication
     */
    public GmailHttpAuthenticator(final Credentials credentials, 
            final Credentials proxyCredentials) {
        this(credentials);
        this.proxyCredentials = proxyCredentials;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        if (log.isDebugEnabled()) {
            log.debug("Password authentication request: " 
                    + getRequestingPrompt());
        }
        if (getRequestorType().equals(RequestorType.PROXY) 
                && proxyCredentials != null) {
            log.debug("Proxy request detected, returning proxy credentials");
            return new PasswordAuthentication(proxyCredentials.getUsername(), 
                    proxyCredentials.getPasword());
        }
        if ("mail.google.com".equals(getRequestingHost())) {
            log.debug("Gmail request detected, returning login credentials");
            return new PasswordAuthentication(credentials.getUsername(), 
                    credentials.getPasword());
        }
        log.debug("Unknown authentication request, will return nothing");
        return null;
    }
    
}
