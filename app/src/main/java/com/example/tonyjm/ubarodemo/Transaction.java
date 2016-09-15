package com.example.tonyjm.ubarodemo;

/**
 * Created by tonyjm on 9/6/16.
 */
public class Transaction {
    private String name;
    private String amount;
    private String date;
    private int id;

    public Transaction(int id, String name, String amount, String date) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
