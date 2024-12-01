package Subscription;

import java.util.Date;

public class CreditCard {
    //attributes
    private final String cardNumber;
    private final Date expiryDate;
    private final String cvv;
    private Float balance;

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CreditCard) {
            CreditCard other = (CreditCard) obj;
            return other.balance.equals(balance)&&other.expiryDate.equals(expiryDate)&&other.cardNumber.equals(cardNumber);
        }
        return false;
    }
}
