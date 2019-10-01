package com.navishka_kularathna;

import java.util.ArrayList;

public class MobilePhone {
    //05.Going to create an option to store the phone number
    private String myNumber;
    //06.Declaring the ArrayList, here we're selecting 'Contacts' instead of a string
    private ArrayList<Contacts> myContacts;

    //07. Creating a Constructor
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        //08.Initializing the ArrayList inside of the constructor, we're starting with an empty list
        this.myContacts = new ArrayList<>();
    }

    //09.Implementing methods
    public boolean addNewContact(Contacts contacts){
        if(findContact(contacts.getName()) >= 0) {
            System.out.println("Contact is already included");
            return false;
        }

        myContacts.add(contacts);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0){
            System.out.println(oldContact.getName() + " was not found");
            return false;
        }

        this.myContacts.set(foundPosition,newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    //12.Remove method
    public boolean removeContact(Contacts contacts){
        int foundPosition = findContact(contacts);
        if (foundPosition < 0){
            System.out.println(contacts.getName() + " was not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contacts.getName() + ", was deleted.");
        return true;
    }

    private int findContact(Contacts contacts){
        return this.myContacts.indexOf(contacts);
    }

    private int findContact(String contactName){
        //10.We are gonna loop through all the records, extract the name out,
        // compare it with the parsed name and return the index of it on the file
        for (int i=0; i<this.myContacts.size(); i++){
            Contacts contacts = this.myContacts.get(i);
            if (contacts.getName().equals(contactName)){
                return i;
            }
        }

        return -1;
    }

    //11.To query the contacts
    public String queryContact(Contacts contacts){
        if (findContact(contacts) >= 0){
            return contacts.getName();
        }
        return null;
    }

    //13.Writing printContacts() method
    public void printContacts(){
        System.out.println("Contact List");
        for (int i=0; i<this.myContacts.size(); i++){
            System.out.println((i+1) + "." +
                    this.myContacts.get(i).getName() + "->" +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }

}
