package com.navishka_kularathna;

public class Contacts {
    //01.Declaring variables
    private String name;
    private String phoneNumber;

    //02.Create a constructor
    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //03.Generating getters, we won't need setters because, every time we're using constructor when we're dealing with a contact record
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //04.Calling the constructor to create a new contact record
    public static Contacts createContact(String name, String phoneNumber){
        return new Contacts(name, phoneNumber);
    }

}
