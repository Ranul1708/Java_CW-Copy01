public class date {
    private int day;
    private int month;
    private int year;

    public date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return this.day;
    }
    public void setDay(int day){
        this.day = day;
    }

    public int getMonth(){
        return this.month= month;
    }
    public void setMonth(int month){
        this.month = month;
    }

    public int getYear(){
        return this.year;
    }
    public  void setYear(int year){
        this.year = year;
    }


    public String toString(){
        return this.day+"/" + this.month+"/"+this.year;
    }
}
