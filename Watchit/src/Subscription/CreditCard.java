package Subscription;

import DataBase.DataObject;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreditCard extends DataObject {
    //attributes
    private final String cardNumber;
    private final Date expiryDate;
    private final String cvv;
    private Float balance;
    //constructors

    public CreditCard(String cardNumber, String cvv,Date expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate =expiryDate;
        this.cvv = cvv;
    }
    public CreditCard(String cardNumber, String cvv, float balance,Date expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate =expiryDate;
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
            Calendar cal = Calendar.getInstance();
            cal.setTime(expiryDate);
            
            int year = cal.get(Calendar.YEAR),month=cal.get(Calendar.MONTH);
            cal.setTime(other.expiryDate);
            return other.cardNumber.equals(cardNumber)&&other.cvv.equals(cvv)
                    &&cal.get(Calendar.YEAR)==year&&cal.get(Calendar.MONTH)==month;
        }
        return false;
    }

    @Override
    public String toString() {
        return cardNumber + ","+ cvv +","+ balance.toString() + System.lineSeparator()+ DateFormat.getInstance().format(expiryDate) +System.lineSeparator();
    }

    @Override
    public Date getDate(){
        return expiryDate;
    }
}
