package Subscription;

import java.util.Date;

public class CreditCard {
    //attributes
    private String cardNumber;
    private Date expiryDate;
    private String cvv;
    private float balance;

    //constructors

    //for Hossam (I don't know why you use default constructor)
    public CreditCard() {
        cardNumber = "";
        expiryDate = null;
        cvv = "";
        balance = 0.F;
    }
    public CreditCard(String cardNumber, Date expiryDate, String cvv, float balance) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.balance = balance;
    }
    //setters
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public void setBalance(float balance) {
        this.balance = balance;
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
}
