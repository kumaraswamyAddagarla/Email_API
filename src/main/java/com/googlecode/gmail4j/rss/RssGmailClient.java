
package com.googlecode.gmail4j.rss;

import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.gmail4j.GmailClient;
import com.googlecode.gmail4j.GmailConnection;
import com.googlecode.gmail4j.GmailException;
import com.googlecode.gmail4j.GmailMessage;
import com.googlecode.gmail4j.GmailMessageList;
import com.googlecode.gmail4j.http.HttpGmailConnection;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;


public class RssGmailClient extends GmailClient {
    
    /**
     * Gmail feed URL. It should remain as is, however you can set a new value.
     * 
     * @see #setGmailFeedUrl(String)
     */
    private String gmailFeedUrl = "https://mail.google.com/mail/feed/atom/unread/";

    /**
     * Gets {@link #gmailFeedUrl}
     * 
     * @return Gmail feed URL
     */
    public String getGmailFeedUrl() {
        return gmailFeedUrl;
    }

    /**
     * Sets {@link #gmailFeedUrl}
     * <p>
     * Use it only if you would like to use another Gmail feed URL than the 
     * default <a href="https://mail.google.com/mail/feed/atom">
     * https://mail.google.com/mail/feed/atom</a>.
     * 
     * @param gmailFeedUrl New Gmail feed URL
     * @throws GmailException if something goes wrong
     */
    public void setGmailFeedUrl(final String gmailFeedUrl) {
        this.gmailFeedUrl = gmailFeedUrl;
    }
    
    @Override
    public List<GmailMessage> getUnreadMessages() {
        final List<GmailMessage> messages = new ArrayList<GmailMessage>();
        HttpGmailConnection c = null;
        try {
            //for ROME properties loader
            Thread.currentThread().setContextClassLoader(getClass()
                    .getClassLoader());
            c = getGmailConnection();
            c.setUrl(gmailFeedUrl);
            final URLConnection con = c.openConnection(); 
            final SyndFeedInput feedInput = new SyndFeedInput();
            final SyndFeed gmail = feedInput.build(new XmlReader(con));
            for (final Object entry : gmail.getEntries()) {
                if (entry instanceof SyndEntry) {
                    messages.add(new RssGmailMessage((SyndEntry) entry));
                }
            }
            if (log.isDebugEnabled()) {
                log.debug("Got " + messages.size() + " new messages.");
            }
        } catch (final Exception e) {
            throw new GmailException("Failed getting unread messages", e);
        }
        return messages;
    }

    @Override
    public GmailMessageList getMessagesBy(EmailSearchStrategy strategy, String value)
    {
        throw new UnsupportedOperationException("RssGmailClient is not " +
                "capable of advanced fetching.");
    }

    /**
     * Gets {@link HttpGmailConnection} (casts it from parent 
     * {@link GmailConnection})
     * 
     * @return HttpGmailConnection if available
     * @throws GmailException if connection is not an instance of 
     *         HttpGmailConnection
     */
    private HttpGmailConnection getGmailConnection() {
        if (connection instanceof HttpGmailConnection) {
            return (HttpGmailConnection) connection;
        } 
        throw new GmailException("RssGmailClient requires HttpGmailConnection!");
    }

    @Override
    public void send(final GmailMessage message) {
        throw new UnsupportedOperationException("RssGmailClient is not " +
        		"capable of sending messages.");
    }
    
    @Override
    public void disconnect() {
    }    
}