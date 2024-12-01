package DataBase;

import AccountControl.Admin;
import AccountControl.User;
import Cast.CastMember;
import Cast.Director;
import ContentControl.WatchRecord;
import Subscription.Subscription;

import java.util.List;

public class InstanceCreator<T> {
    InstanceCreator(ReturnedData re, List<T>data,char c) {
        if(c=='U'){
            User newUser = (new User(re.longs.get(0), re.strings.get(0), re.strings.get(3), re.strings.get(4), re.strings.get(2), re.strings.get(1), new Subscription(re.longs.get(0), re.integers.get(0), re.dates.get(0), re.dates.get(1)), re.stringLists.get(1), re.stringLists.get(2), re.stringLists.get(0), re.strings.get(5)));
            data.add((T)newUser);
        }else if(c=='C'){
            CastMember cast = new CastMember(re.longs.get(0),re.strings.get(0),re.strings.get(1), re.strings.get(2),re.strings.get(3),re.strings.get(4),re.stringLists.get(0),re.dates.get(0));
            data.add((T)cast);
        }else if(c=='W'){
            WatchRecord newWatchRecord = new WatchRecord(re.longs.get(0),re.floats.get(0),re.strings.get(0),re.dates.get(0));
            data.add((T)newWatchRecord);
        }else if(c=='A'){
            Admin newAdmin = new Admin(re.longs.get(0),re.strings.get(0),re.strings.get(1),re.strings.get(2),re.strings.get(3),re.strings.get(4),re.strings.get(5));
            data.add((T)newAdmin);
        }else if(c=='D'){
            Director newDirector = new Director(re.longs.get(0),re.strings.get(0),re.strings.get(1), re.strings.get(2),re.strings.get(3),re.strings.get(4),re.stringLists.get(0),re.dates.get(0));
            data.add((T)newDirector);
        }
    }
}
