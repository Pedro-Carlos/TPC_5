package c.book;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.Objects;

import e.exceptions.ContactAlreadyExistsException;
import e.exceptions.ContactDoesNotExistException;

public class ContactBookInList implements ContactBook {
    /**
     * A collection of contacts.
     */
    List<Contact> contacts;

    /**
     * Default constructor
     */
    public ContactBookInList() {
        contacts = new LinkedList<>();
    }

    @Override
    public boolean hasContact(String name) {
        return this.getContact(name) != null;
    }

    @Override
    public int getNumberOfContacts() {
        return contacts.size();
    }

    @Override
    public void addContact(String name, int phone, String email) throws ContactAlreadyExistsException {
        if (hasContact(name))
            throw new ContactAlreadyExistsException();
        else
            contacts.add(new ContactClass(name, phone, email));
    }

    @Override
    public void deleteContact(String name) throws ContactDoesNotExistException {
        if (hasContact(name))
            contacts.remove(new ContactClass(name));
        else
            throw new ContactDoesNotExistException();
    }

    @Override
    public int getPhone(String name) throws ContactDoesNotExistException {
            if (hasContact(name))
                return Objects.requireNonNull(this.getContact(name)).getPhone();
            else
                throw new ContactDoesNotExistException();

    }

    @Override
    public String getEmail(String name) throws ContactDoesNotExistException {
        if (hasContact(name))
            return Objects.requireNonNull(this.getContact(name)).getEmail();
        else
            throw new ContactDoesNotExistException();
    }

    @Override
    public void setPhone(String name, int phone) throws ContactDoesNotExistException {
        try {
            Objects.requireNonNull(this.getContact(name)).setPhone(phone);
        }catch(Exception e){
            throw new ContactDoesNotExistException();}
    }

    @Override
    public void setEmail(String name, String email) throws ContactDoesNotExistException {
        if (hasContact(name))
            Objects.requireNonNull(this.getContact(name)).setEmail(email);
        else
            throw new ContactDoesNotExistException();
    }

    @Override
    public Iterator<Contact> listContacts() {
        return contacts.iterator();
    }

    /**
     * @param name The contact name to lookup in the list
     * @return the <code>name</code> of the contact, if it exists,
     * otherwise <code>null</code>
     */
    private Contact getContact(String name){
        for (Contact c: contacts)
            if (c.getName().equals(name))
                return c;
            return null;
    }
}
