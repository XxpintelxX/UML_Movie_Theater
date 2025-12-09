package fr.efrei.domain;

public class Customer {
    private int customerID;
    private static int customerIDCounter = 0;
    private String name;
    private String surName;
    private String email;
    private String phone;
    private String password;
    private double balance;

    public Customer() {}

    public Customer(String name, String surName, String email, String phone, String password, double balance) {
        customerIDCounter++;
        this.customerID = customerIDCounter;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.balance = balance;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double deposit) {
        balance += deposit;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public boolean canPay(double price) {
        boolean isAbleToPay = false;
        if (price <= balance)
            isAbleToPay = true;

        return isAbleToPay;
    }

    public void paying(double price) {
        balance -= price;
    }
}
