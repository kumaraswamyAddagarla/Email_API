
package com.googlecode.gmail4j;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.googlecode.gmail4j.javamail.MessageHeaderInfo;


public abstract class GmailMessage {

    /**
     * Gets Gmail message subject
     * 
     * @return Message subject
     */
    public abstract String getSubject();

    /**
     * Sets message subject
     * 
     * @param subject
     *            Subject to be set
     * @throws UnsupportedOperationException
     *             if implementation does not provide this feature.
     */
    public void setSubject(final String subject) {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not support setSubject()");
    }

    /**
     * Gets the {@link Date} this message was sent
     * 
     * @return Send date
     */
    public abstract Date getSendDate();

    /**
     * Gets the sender {@link EmailAddress}
     * 
     * @return Sender email address
     */
    public abstract EmailAddress getFrom();

    /**
     * Sets message sender's {@link EmailAddress}
     * 
     * @param from
     *            Sender's email address
     * @throws UnsupportedOperationException
     *             if implementation does not provide this feature.
     */
    public void setFrom(final EmailAddress from) {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not support setFrom()");
    }

    /**
     * Gets a list of message "To:" recipient {@link EmailAddress}
     * <code>es</code>
     * 
     * @return list of message "To:" recipient email addresses
     * @throws UnsupportedOperationException
     *             if implementation does not provide this functionality
     */
    public List<EmailAddress> getTo() {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not support getTo()");
    }

    /**
     * Gets a list of message "Cc:" recipient {@link EmailAddress}
     * <code>es</code>
     * 
     * @return list of message "Cc:" recipient email addresses
     * @throws UnsupportedOperationException
     *             if implementation does not provide this functionality
     */
    public List<EmailAddress> getCc() {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not provide getCc()");
    }

    /**
     * Adds carbon copy message recipient's {@link EmailAddress}
     * 
     * @param cc
     *            Carbon copy recipient's email address
     * @throws UnsupportedOperationException
     *             if implementation does not provide this feature.
     */
    public void addCc(final EmailAddress cc) {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not support addCc()");
    }

    /**
     * Adds blind carbon copy message recipient's {@link EmailAddress}
     * 
     * @param bcc
     *            Blind carbon copy recipient's email address
     * @throws UnsupportedOperationException
     *             if implementation does not provide this feature.
     */
    public void addBcc(final EmailAddress bcc) {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not support addBcc()");
    }

    /**
     * Adds message recipient's {@link EmailAddress}
     * 
     * @param to
     *            Recipient's email address
     * @throws UnsupportedOperationException
     *             if implementation does not provide this feature.
     */
    public void addTo(final EmailAddress to) {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not support addTo()");
    }

    /**
     * Gets a direct link to this Gmail message
     * 
     * @return Web link to this message
     * @throws UnsupportedOperationException
     *             if implementation does not provide this functionality
     */
    public String getLink() {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not provide getLink()");
    }

    /**
     * Gets a content text preview for this message
     * 
     * @return Text preview for this message
     * @throws UnsupportedOperationException
     *             if implementation does not provide this functionality
     */
    public String getPreview() {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not provide getPreview()");
    }

    /**
     * Gets content text for this message
     * 
     * @return Text content for this message
     * @throws UnsupportedOperationException
     *             if implementation does not provide this functionality
     */
    public String getContentText() {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not provide getContentText()");
    }

    /**
     * Sets content text for this message
     * 
     * @return Text content for this message
     * @throws UnsupportedOperationException
     *             if implementation does not provide this functionality
     */
    public void setContentText(final String contentText) {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not provide setContentText()");
    }

    /**
     * Gets the message number
     * 
     * @return Message number
     */
    public abstract int getMessageNumber();

    /**
     * Gets message headers from this part and wrap as {@link MessageHeaderInfo}
     * .
     * 
     * @return {@link MessageHeaderInfo} object
     * @throws UnsupportedOperationException
     *             if implementation does not provide this functionality
     */
    public MessageHeaderInfo getMessageHeaderInfo() {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not provide getMessageHeaderInfo()");
    }

    /**
     * AddAttachement to the message.
     * 
     * @param file
     *            file to attach.
     */
    public void addAttachement(File file) {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not provide addAttachement()");
    }

    /**
     * Get a list of all message attachements.
     * 
     * @return list of all message attachements
     */
    public List<GmailAttachment> getAttachements() {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not provide getAttachements()");
    }

    /**
     * Get a specific attachement from part index. To get the part index a call
     * to getAttachements can be necessary before calling this function.
     * 
     * @param partIndex Part index in the multipart message.
     * @return attachement.
     */
    public GmailAttachment getAttachment(int partIndex) {
        throw new UnsupportedOperationException("This GmailMessage "
                + "implementation does not provide getAttachment()");
    }
}
