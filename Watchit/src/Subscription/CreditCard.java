package Subscription;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreditCard{
    //attributes
    private final String cardNumber;
    private final String cvv;
    private final String type;
    private final String cardHolderName;
    private final Date expiryDate;
    //constructors
    public CreditCard(String cardNumber, String cardHolderName, String type, String cvv, Date expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.type = type;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }
    //getters
    public String getCardNumber() {
        return cardNumber;
    }
    public String getCvv() {
        return cvv;
    }
    public String getType() {
        return type;
    }
    public String getCardHolderName() {
        return cardHolderName;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CreditCard) {
            CreditCard other = (CreditCard) obj;
            return this.cardNumber.equals(other.cardNumber)
                    && this.cvv.equals(other.cvv) && this.type.equals(other.type)
                    && this.cardHolderName.equals(other.cardHolderName)
                    && this.expiryDate.getMonth() == other.expiryDate.getMonth()
                    && this.expiryDate.getYear() == other.expiryDate.getYear();
        }
        return false;
    }
    @Override
    public String toString() {
        return cardNumber + "," + cardHolderName + "," + type + "," + cvv + "\n" +DateFormat.getInstance().format(expiryDate)+"\n";
    }
}
