package ru.qa.ui.pageobject.models;

import lombok.*;

@Data
public class Account {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dayBirth;
    private String monthBirth;
    private String yearBirth;
    private String address;
    private String city;
    private String state;
    private String postCode;
    private String country;
    private String phone;


    public Account(String firstName, String lastName, String email, String password, String dayBirth, String monthBirth, String yearBirth, String address, String city, String state, String postCode, String country, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dayBirth = dayBirth;
        this.monthBirth = monthBirth;
        this.yearBirth = yearBirth;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.country = country;
        this.phone = phone;
    }

    public Account() {
        this.firstName ="Иван" ;
        this.lastName ="Иванов" ;
        this.password = "QWERTY!@#$";
        this.dayBirth="1";
        this.monthBirth="1";
        this.yearBirth="1999";
        this.address = "selo";
        this.city ="Albuquerque";
        this.state = "New Mexico";
        this.postCode = "87001";
        this.country = "United States";
        this.phone = "12345678910";
    }

}
