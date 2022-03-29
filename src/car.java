/*This class is the blue print of "Team objects"
*Every driver class is has a "Association" relationship with this class
* A team can exist without a Driver. And A team is unique to each Driver
* Objects created from this class is saved in a array called teamweather or not associated with a driver object,
* the object will remain. Once a driver is about to be assign to an existing team, the remaining team objects will be used to create a new association with the driver
 */

import java.io.Serializable;

public class car implements Serializable {
    private String carName ;
   // private formula01Driver Driver;

    public car(String teamName){
        this.carName = teamName;
      //  this.Driver = driver;

    }
    public car(){
        carName="";
    }
    public void setCarName(String carName){
        this.carName = carName;
    }
    public String getCarName(){
        return this.carName;
    }
 /*   public void setdriver(formula01Driver driver){
        this.Driver = driver;
    }
    public formula01Driver getDriver(){
        return this.Driver;
    } */
    public String toString(){
        return /*"Team Name:"+*/this.carName;
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
        if (obj == null || !(obj instanceof car))
            return false;
        car otherCar = (car) obj;
        if (!otherCar.carName.equals(this.carName)) return false;
        return true;
    }



}
