package c.book;

/**
 * By removing the public visibility, this class is no longer visible outside the package
 */
class ContactClass implements Contact {
    /**
     * Contact name.
     */
    //Changed to final
    private final String name;

    /**
     * Contact phone number.
     */
    private int phone;

    /**
     * Contact the email address.
     */
    private String email;

    /**
     * Default constructor
     */
    public ContactClass(String name, int phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Constructor with just the name. Leaves the phone number at 0, and the email address to null.
     */
    public ContactClass(String name) {
        this(name, 0, null);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPhone() {
        return phone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        //Removed unused if's and else's
        if (!(obj instanceof Contact other)) return false;

        return name.equals(other.getName());
    }
    @Override //Added method hashCode
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public String toString() {
        return getName() + "; " + email + "; " + getPhone();
    }
}
