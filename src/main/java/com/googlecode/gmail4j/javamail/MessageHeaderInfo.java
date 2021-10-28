
package com.googlecode.gmail4j.javamail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MessageHeaderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Gmail Message-ID for unique mail identification.
     */
    private final String messageId;
    /**
     * Gmail message Subject of the incoming message.
     */
    private String subject;
    /**
     * Gmail conversation Message-ID References for the incoming message.
     */
    private final List<String> references;
    /**
     * Gmail conversation In-Reply-To Message-ID for the incoming message.
     */
    private String inReplyTo;

    /**
     * Constructor with Gmail messageId
     *
     * @param messageId Gmail Message-ID for unique mail identification.
     */
    public MessageHeaderInfo(final String messageId) {
        this.references = new ArrayList<String>();
        this.messageId = messageId;
    }

    /**
     * Sets {@link #subject}.
     * <p>
     * @param subject Gmail message Subject of the incoming message.
     */
    public void setSubject(final String subject) {
        this.subject = subject;
    }

    /**
     * Sets {@link #inReplyTo}.
     * <p>
     * @param inReplyTo Gmail conversation In-Reply-To Message-ID for the
     * incoming message.
     */
    public void setInReplyTo(final String inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    /**
     * Adds {@link #references}.
     * <p>
     * @param reference Gmail conversation Message-ID Reference for the
     * incoming message.
     */
    public void addReferences(final String reference) {
        references.add(reference);
    }

    /**
     * Gets the {@link #messageId}
     *
     * @return Message-ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Gets the {@link #subject}
     *
     * @return message Subject of the incoming message.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Gets the {@link #inReplyTo}
     *
     * @return conversation In-Reply-To Message-ID for the incoming message.
     */
    public String getInReplyTo() {
        return inReplyTo;
    }

    /**
     * Gets the {@link #references}
     *
     * @return conversation Message-ID References for the incoming message.
     */
    public List<String> getReferences() {
        return (references == null ? Collections.<String>emptyList()
                : new ArrayList<String>(references));
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MessageHeaderInfo other = (MessageHeaderInfo) obj;
        if ((this.messageId == null) ? (other.messageId != null)
                : !this.messageId.equals(other.messageId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.messageId != null
                ? this.messageId.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "MessageHeaderInfo{" + "messageId=" + messageId
                + "subject=" + subject + "references=" + references
                + "inReplyTo=" + inReplyTo + '}';
    }
}
