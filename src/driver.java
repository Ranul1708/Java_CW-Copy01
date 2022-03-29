import java.io.Serial;

/*
*This class holds the initial information of the driver
 */
import java.io.Serializable;

public abstract class driver implements Serializable {
    private String name;
    private String location;
    private car team;  //Association relationship between Driver and Team
    private String contestantTeam;


    //Constructors for the Driver class
    public driver (String name, String location,car team){
        this.name=name;
        this.location = location;
        this.team = team;

    }
    public driver(String name,String contestantteamname){
        this.name = name;
        this.contestantTeam = contestantteamname;

    }




    //Setters and getters for the classes
    //---------- name-------------
    public String getName(){
        return this.name ;
    }
    public void setName(String name){
         this.name = name ;
    }

    //---------- Location-------------
    public String getLocation(){
        return this.location ;
    }
    public void setLocation(String Location){
        this.location = Location ;
    }
    //---------- team-------------
    public car getTeam(){
        return this.team ;
    }
    public void setTeam(car team){
        this.team = team ;
    }

    //-------contestant team--------------
    public String getcontestantTeam(){
        return this.contestantTeam ;
    }
    public void setcontestantTeam(String team){
        this.contestantTeam = team ;
    }

    /* " . equals() method" was not functioning for objects.
    In order to avoid it, this method was overridden in all the classes of which Driver object is made of
    Since the classes car, driver ,formula01Driver are used to create actual formula01 Driver objects, the following method is
    implemented in all those classes
     */
    @Override
    public boolean equals(final Object obj)
    {
        if (obj == this)
            return true;

        if (obj == null || !(obj instanceof driver))
            return false;

        driver otherDriver = (driver) obj;


        if (!otherDriver.name.equals(this.name)) return false;
        if (!otherDriver.team.equals(this.team)) return false;
        if (!otherDriver.location.equals(this.location)) return false;
        if (!otherDriver.name.equals(this.name)) return false;
        if (!otherDriver.contestantTeam.equals(this.contestantTeam)) return false;

        return true;
    }

    //Overriding toString() method
    public String toString(){
        return "Name:" + this.name +
                "Location:" + this.location +
                "team:"+this.team;
    }




}
