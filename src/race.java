/*
Holds the date of the race as an object
Holds the Arraylist of contestants driver objects

 */
import java.util.ArrayList;

public class race {
    private date date;
    public ArrayList<contestantDriver> contestants = new ArrayList<contestantDriver>(3);

    public race(contestantDriver driver){
        this.contestants.add(driver);

    }
    public date getDate(){
        return this.date;
    }
    public void setDate(date date){
        this.date = date;
    }

}
