package org.aptech.t2303e;

public class Customer {
    String name;
    String email;
    String phoneNumber;

    public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Phone Number: " + phoneNumber;
    }
}
