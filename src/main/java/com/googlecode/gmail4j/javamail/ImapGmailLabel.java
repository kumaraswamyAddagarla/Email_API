
package com.googlecode.gmail4j.javamail;

public enum ImapGmailLabel {
    /**
     * Imap Gmail folder label name for {@code [Gmail]/All Mail}
     */
    ALL_MAIL("[Gmail]/All Mail"),
    /**
     * Imap Gmail folder label name for {@code [Gmail]/Drafts}
     */
    DRAFTS("[Gmail]/Drafts"),
    /**
     * Imap Gmail folder label name for {@code [Gmail]/Sent Mail}
     */
    SENT_MAIL("[Gmail]/Sent Mail"),
    /**
     * Imap Gmail folder label name for {@code [Gmail]/Spam}
     */
    SPAM("[Gmail]/Spam"),
    /**
     * Imap Gmail folder label name for {@code [Gmail]/Starred}
     */
    STARRED("[Gmail]/Starred"),
    /**
     * Imap Gmail folder label name for {@code INBOX}
     */
    INBOX("INBOX"),
    /**
     * Imap Gmail folder label name for {@code [Gmail]/Trash}
     */
    TRASH("[Gmail]/Trash"),
    /**
     * Imap Gmail folder label name for {@code [Gmail]/Important}
     */
    IMPORTANT("[Gmail]/Important");
   
    /**
     * Imap Gmail folder label name
     */
    private String name;

    /**
     * Constructor with Imap Gmail label name
     *
     * @param name Gmail Imap folder label name
     */
    private ImapGmailLabel(String name) {
        this.name = name;
    }

    /**
     * Gets the {@link #name}
     *
     * @return name of the Gmail Imap folder label.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}