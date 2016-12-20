package com.dip.core.pojos;

/**
 * Created by Юрий on 30.10.2016.
 */

public class Teacher {
    String familyName;
    String firstName;
    String secondName;
    String phone;

    public Teacher(String familyName, String firstName, String secondName, String phone) {
        this.familyName = familyName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhone() {
        return phone;
    }
}
