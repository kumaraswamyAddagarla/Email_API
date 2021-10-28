
package com.googlecode.gmail4j;


public class EmailAddress {

    /**
     * Email address
     */
    private final String email;
    
    /**
     * Email owner's name
     */
    private String name;
    
    /**
     * Constructor with Email address
     * 
     * @param email Email address
     */
    public EmailAddress(final String email) {
        this(null, email);
    }
    
    /**
     * Constructor with Person name and email address
     * 
     * @param name Person name
     * @param email Email address
     */
    public EmailAddress(final String name, final String email) {
        if (name != null && name.length() > 0) {
            this.name = name;
        }
        this.email = email;
    }
    
    /**
     * Tells if this email address has a defined person name 
     * 
     * @return true if name exists
     * @since 0.3
     */
    public boolean hasName() {
        return name != null && name.length() > 0;
    }
    
    /**
     * Gets person {@link #name} or first part of email address if name is not 
     * set
     * 
     * @return name or first part of email address
     */
    public String getName() {
        return name == null ? email.replaceFirst("@.*", "") : name;
    }
    
    /**
     * Gets Email address
     * 
     * @return {@link #email}
     */
    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
        return name == null ? email : name.concat(" <").concat(email).concat(">");
    }
}
