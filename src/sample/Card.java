package sample;

import java.io.Serializable;
import java.util.Date;

public class Card implements Serializable {
    private static final long serialVersionUID=9180844317717290831L; //Для правильной передачи обьекта

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String number1;
    private String pin;
    private String nameHolder;
    private String surnameHolder;
    private String validity;
    private long balance;

    public Card(int id, String number1, String pin, String nameHolder, String surnameHolder, String validity, long balance) {
        this.id = id;
        this.number1 = number1;
        this.pin = pin;
        this.nameHolder = nameHolder;
        this.surnameHolder = surnameHolder;
        this.validity = validity;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number1 + '\'' +
                ", pin='" + pin + '\'' +
                ", nameHolder='" + nameHolder + '\'' +
                ", surnameHolder='" + surnameHolder + '\'' +
                ", validity='" + validity + '\'' +
                ", balance=" + balance +
                '}';
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getNameHolder() {
        return nameHolder;
    }

    public void setNameHolder(String nameHolder) {
        this.nameHolder = nameHolder;
    }

    public String getSurnameHolder() {
        return surnameHolder;
    }

    public void setSurnameHolder(String surnameHolder) {
        this.surnameHolder = surnameHolder;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }



    public Card() {
    }
}
