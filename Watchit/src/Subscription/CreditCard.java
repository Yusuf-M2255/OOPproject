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
    private final String type;
    private final String CardHolderName;

    public CreditCard(String cardNumber,String CardHolderName,String type, String cvv,Date expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate =expiryDate;
        this.type = type;
        this.CardHolderName=CardHolderName;
        this.cvv = cvv;
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
    //--------------------------------------DataBase Methods-----------------------------------------//
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof CreditCard) {
            CreditCard other = (CreditCard) obj;
            return other.type.equals(type)&& other.CardHolderName.equals(CardHolderName)&&other.cardNumber.equals(cardNumber)&&other.cvv.equals(cvv)
                    &&other.expiryDate.getYear()==expiryDate.getYear()&&other.expiryDate.getMonth()==expiryDate.getMonth();
        }
        return false;
    }

    @Override
    public String toString() {
        return cardNumber +","+ CardHolderName+","+ type+","+cvv+System.lineSeparator()+ DateFormat.getInstance().format(expiryDate)+System.lineSeparator();
    }

    @Override
    public Date getDate(){
        return expiryDate;
    }
}
