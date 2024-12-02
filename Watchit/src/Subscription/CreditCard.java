package Subscription;

import DataBase.DataObject;

import java.text.DateFormat;
import java.util.Date;

public class CreditCard extends DataObject {
    //attributes
    private final String cardNumber;
    private final Date expiryDate;
    private final String cvv;
    private Float balance;
    //constructors

    public CreditCard() {
        cardNumber = "";
        expiryDate = null;
        cvv = "";
        balance = 0.F;
    }
    public CreditCard(String cardNumber, String cvv, float balance,Date expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.balance = balance;
    }
    void Pay(Float amount) {
        balance-=amount;
    }

    void addMoney(Float amount) {
        balance+=amount;
    }

    //getters
    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
    public String getCvv() {
        return cvv;
    }
    public float getBalance() {
        return balance;
    }
    //--------------------------------------DataBase Methods-----------------------------------------//
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CreditCard) {
            CreditCard other = (CreditCard) obj;
            return other.balance.equals(balance)&&other.expiryDate.equals(expiryDate)&&other.cardNumber.equals(cardNumber);
        }
        return false;
    }

    @Override
    public String toString() {
        return cardNumber + " "+ cvv +" "+ balance.toString() + System.lineSeparator()+ DateFormat.getInstance().format(expiryDate) +System.lineSeparator();
    }

    @Override
    public Date getDate(){
        return expiryDate;
    }
}
