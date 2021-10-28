
package com.googlecode.gmail4j.rss;

import java.util.Date;

import com.googlecode.gmail4j.EmailAddress;
import com.googlecode.gmail4j.GmailMessage;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndPerson;


public class RssGmailMessage extends GmailMessage {

    /**
     * <a href="https://rome.dev.java.net/">ROME</a> SyndEntry object with 
     * Gmail message content.
     */
    private final SyndEntry rssEntry;
    
    /**
     * Sender's {@link EmailAddress}
     */
    private EmailAddress from = null;
    
    /**
     * Cache for {@link #toString()}
     */
    private StringBuilder toString = null;
    
    /**
     * Package-protected constructor with {@link SyndEntry} source
     * 
     * @param rssEntry Source object
     */
    RssGmailMessage(final SyndEntry rssEntry) {
        this.rssEntry = rssEntry;
    }
    
    @Override
    public String getSubject() {
        return rssEntry.getTitle();
    }

    @Override
    public EmailAddress getFrom() {
        if (from == null) {
            final SyndPerson author = (SyndPerson) rssEntry.getAuthors().get(0);
            from = new EmailAddress(author.getName(), author.getEmail());
        }
        return from;
    }
    
    @Override
    public String getLink() {
        return rssEntry.getLink();
    }
    
    @Override
    public Date getSendDate() {
         return rssEntry.getPublishedDate();
    }
    
    @Override
    public String getPreview() {
        return rssEntry.getDescription().getValue();
    }
    
    @Override
    public String toString() {
        if (toString != null) {
            return toString.toString();
        }
        toString = new StringBuilder();
        toString.append("MailMessage:{from:").append(getFrom())
            .append(";sendDate:").append(getSendDate())
            .append(";subject:").append(getSubject())
            .append(";preview:").append(getPreview()).append(";}");
        return toString.toString();
    }

    @Override
    public int getMessageNumber() {
        throw new UnsupportedOperationException("RssGmailClient is not " +
        		"capable of getting message number.");
    }
}
