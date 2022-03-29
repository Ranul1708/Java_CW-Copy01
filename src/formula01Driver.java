/*
* This class is the blue print for all the drivers
* This perticular class contains the statistic details of the driver
* Extends the "Driver class"
* implements "serializable" interface for the purpose of file handling
* implements "Complarable" interface for the purpose of comparing the objects in future applications
*
* */


import java.io.Serializable;

public class formula01Driver extends driver implements Serializable,Comparable<formula01Driver> {
    //Variables to hold the statistics of the driver
    private car team;
    private int totalFirstPositions;
    private int totalSecondPositions;
    private int totalThirdPositions;
    private int totalPointsGained;
    private int totalRacesParticipated;
    private int position;
    private int pointsForLastRace;

    //constructor - populates the variables
    public formula01Driver(String name, String location, car team, int P01, int P02, int P03, int totalPoints, int totalRaces){
        super(name, location, team);
        this.totalFirstPositions = P01;
        this.totalSecondPositions = P02;
        this.totalThirdPositions = P03;
        this.totalPointsGained = totalPoints;
        this.totalRacesParticipated = totalRaces;
        this.team=team;
    }


    //Setters and getters for the variables
    public int getTotalFirstPositions(){
        return totalFirstPositions;
    }
    public void setTotalFirstPositions(int P01){
        this.totalFirstPositions = P01;
    }//------------------------------------------
    public int getTotalSecondPositions(){
        return totalSecondPositions;
    }
    public void setTotalSecondPositions(int P02){
        this.totalSecondPositions = P02;
    }//------------------------------------------
    public int getTotalThirdPositions(){
        return totalThirdPositions;
    }
    public void setTotalThirdPositions(int P03){
        this.totalThirdPositions = P03;
    }//------------------------------------------
    public int getTotalPointsGained(){
        return totalPointsGained;
    }
    public void setTotalPointsGained(int totalPoints){
        this.totalPointsGained = totalPoints;
    }//------------------------------------------
    public int getTotalRacesParticipated(){
        return totalRacesParticipated;
    }
    public void setTotalRacesParticipated(int totalRaces){
        this.totalRacesParticipated = totalRaces;
    }//----------------------------------------
    public int getPosition(){
        return this.position;
    }
    public void setPosition(int position){

        this.position = position;
    }//-----------------------------------------
    public int getPointsForLastRace(){
        return getPointsForLastRace();
    }
    public void setPointsForLastRace(int points){
        this.pointsForLastRace = points;
    }

    public car getTeam(){
        return this.team ;
    }
    public void setTeam(car team){
        this.team = team ;
    }

    //overriding the compareto() method of "Comparable interface"
    @Override
    public int compareTo(formula01Driver o1){
        if(o1.getTotalPointsGained()> this.getTotalPointsGained()){
            return 1;
        }else if(o1.getTotalPointsGained()<this.getTotalPointsGained()){
            return -1;
        }
        return 0;
    }

  public void addRaceInformation(int position){
  /*When adding a new race each driver object is evaluated. In tha process the
   position of each driver is pased into this method.
   This method executes the task of "giving marks according to the position driver achieved"
   Only the first 10 drivers will be awarded with points
   */

            switch (position) {
                case 1:
                    this.totalFirstPositions += 1;
                    this.totalPointsGained += 25;
                    break;
                case 2:
                    this.totalSecondPositions += 1;
                    this.totalPointsGained += 18;
                    break;
                case 3:
                    this.totalThirdPositions += 1;
                    this.totalPointsGained += 15;
                    break;
                case 4:
                    this.totalPointsGained += 12;
                    break;
                case 5:
                    this.totalPointsGained += 10;
                    break;
                case 6:
                    this.totalPointsGained += 8;
                    break;
                case 7:
                    this.totalPointsGained += 6;
                    break;
                case 8:
                    this.totalPointsGained += 4;
                    break;
                case 9:
                    this.totalPointsGained += 2;
                    break;
                case 10:
                    this.totalPointsGained += 1;
                    break;
            }
            this.totalRacesParticipated+=1;


    }
    public String toString(){
        //overriding the "toString method",to make the printing of the object easier
        return /*"Total first positions:"+ " "+*/ this.totalFirstPositions +" "+
                /*"Total second positions:"+ " "+*/ this.totalSecondPositions+" "+
               /* "Total third positions:" + " " +*/ this.totalThirdPositions+" "+
               /* "Total Points gained:"+" "+*/ this.totalPointsGained+" "+
               /* "Total Races Participated"+ " "+*/ this.totalRacesParticipated+" "+
               /* "Position gained in the last race participated:" +*/this.position+" "+
               /* "Points gained in the last race participated:"+*/ this.pointsForLastRace;
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

        if (obj == null || !(obj instanceof formula01Driver))
            return false;

        formula01Driver otherCard = (formula01Driver) obj;

        if (otherCard.totalSecondPositions != this.totalSecondPositions)       return false;
        if (otherCard.totalFirstPositions != this.totalFirstPositions)     return false;
        if (otherCard.totalThirdPositions != this.totalThirdPositions)     return false;
        if (otherCard.totalPointsGained != this.totalPointsGained)     return false;
        if (otherCard.totalRacesParticipated != this.totalRacesParticipated)     return false;
        if (otherCard.position != this.position)     return false;
        if (otherCard.pointsForLastRace!= this.pointsForLastRace)     return false;


        return true;
    }





}
