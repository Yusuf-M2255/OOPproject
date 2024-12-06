package DataBase;

import AccountControl.*;
import Cast.*;
import ContentControl.*;
import Subscription.*;

import java.util.List;

public class InstanceCreator<T> {
    InstanceCreator(ReturnedData re, List<T>data,char c) {
        if(c=='U'){
            User newUser = (new User(re.longs.get(0), re.strings.get(0), re.strings.get(3), re.strings.get(4), re.strings.get(2), re.strings.get(1), new Subscription(re.longs.get(0), re.integers.get(0), re.dates.get(0), re.dates.get(1)), re.stringLists.get(1), re.stringLists.get(2), re.stringLists.get(0), re.strings.get(5)));
            data.add((T)newUser);
            DataBase.accountsData.addData((Account)newUser);
        }else if(c=='C'){
            CastMember cast = new CastMember(re.longs.get(0),re.strings.get(0),re.strings.get(1), re.strings.get(2),re.strings.get(3),re.strings.get(4),re.stringLists.get(0),re.dates.get(0));
            data.add((T)cast);
        }else if(c=='W'){
            WatchRecord newWatchRecord = new WatchRecord(re.longs.get(0),re.floats.get(0),re.strings.get(0),re.dates.get(0));
            data.add((T)newWatchRecord);
        }else if(c=='A'){
            Admin newAdmin = new Admin(re.longs.get(0),re.strings.get(0),re.strings.get(1),re.strings.get(2),re.strings.get(3),re.strings.get(4),re.strings.get(5));
            data.add((T)newAdmin);
            DataBase.accountsData.addData((Account)newAdmin);
        }else if(c=='D'){
            Director newDirector = new Director(re.longs.get(0),re.strings.get(0),re.strings.get(1), re.strings.get(2),re.strings.get(3),re.strings.get(4),re.stringLists.get(0),re.dates.get(0));
            data.add((T)newDirector);
        }else if (c=='M'){
            Movie newMovie = new Movie(re.longs.get(0),re.strings.get(0),re.strings.get(1),re.strings.get(2),re.strings.get(3),re.integers.get(0),re.integers.get(1),re.integers.get(2),re.stringLists.get(0),re.stringLists.get(1),re.dates.get(0));
            data.add((T)newMovie);
            DataBase.contentsData.addData((Content) newMovie);
        }else if(c=='S'){
            Series newSeries = new Series(re.longs.get(0),re.strings.get(0),re.strings.get(1),re.strings.get(2),re.strings.get(3),re.integers.get(0),re.integers.get(1),re.integers.get(2),re.integers.get(3),re.stringLists.get(0),re.stringLists.get(1),re.dates.get(0),re.dates.get(1));
            data.add((T)newSeries);
            DataBase.contentsData.addData((Content) newSeries);
        } else if (c =='E') {
            Episode newEpisode = new Episode(re.longs.get(0),re.strings.get(0),re.strings.get(1),re.integers.get(0),re.integers.get(1),re.dates.get(1));
            data.add((T)newEpisode);
        } else {
            CreditCard newCreditCard = new CreditCard(re.strings.get(0),re.strings.get(1),re.strings.get(2),re.strings.get(3),re.dates.get(0));
            data.add((T)newCreditCard);
        }
    }
}
