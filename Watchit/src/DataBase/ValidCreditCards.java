package DataBase;

import ContentControl.Movie;
import Subscription.CreditCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ValidCreditCards {
    private List<CreditCard> CreditCards =null ;
    public ValidCreditCards(){
        CreditCards = new ArrayList<>();
        //LoadData();
    }

    /**
     * get Data of movies from files
     * its throws messages when files not founded or any other error
     */
    public void LoadData(){

        File CreditCardsFile = new File("./creditCards.txt");
        try {
            if(!CreditCardsFile.exists()){
                CreditCardsFile.createNewFile();
            }
            Scanner scanner = new Scanner(CreditCardsFile);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                String CreditCardNumber = data[0];
                String CCV = data[1];
                float Balance = Float.parseFloat(data[2]);
                Date ExpiryDate = DateFormat.getInstance().parse(scanner.nextLine());
                CreditCards.add(new CreditCard(CreditCardNumber,ExpiryDate,CCV,Balance));
            }
        }catch (FileNotFoundException e){
            System.out.println("File CreditCards.txt is not found");
        }
        catch (Exception e){
            System.out.println("error while opening");
        }
    }


    /**
     * save Data of CreditCards in files
     * its throws messages when files not founded or any other error
     */
    public void SaveData(){
        File CreditCardsFile = new File("./CreditCards.txt");
        try {
            if(!CreditCardsFile.exists()){
                CreditCardsFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(CreditCardsFile);
            for(CreditCard cc : CreditCards){
                fos.write(cc.getCardNumber().toString().getBytes());
                fos.write(" ".getBytes());
                fos.write(cc.getCvv().getBytes());
                fos.write(" ".getBytes());
                fos.write(Float.toString(cc.getBalance()).getBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write(DateFormat.getInstance().format(cc.getExpiryDate()).getBytes());
            }
        }catch (FileNotFoundException e){
            System.out.println("File CreditCards.txt is not found");
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Save CreditCards.txt failed");
        }
    }

    public CreditCard FindCreditCard(CreditCard creditCard){
        for(CreditCard cc : CreditCards){
            if(cc.equals(creditCard)){
                return cc;
            }
        }
        return null;
    }
}
