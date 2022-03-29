/*
*
 */

import java.io.*;
import java.sql.Array;
import java.sql.Driver;
import java.util.*;

public class formula01ChampionshipManager implements championshipManager{

    static String name;
    static String location;
    static String teamName;
    static String currentTeam;
    static car newTeam;

    int totalFirstPositions;
    int totalSecondPositions;
    int totalThirdPositions;
    int totalPointsGained;
    int totalRacesParticipated;

    int Position;
    int pointsForLastRace;

    int day;
    int month;
    int year;

    File file = new File("C:\\Users\\DELL\\IdeaProjects\\Java_CW\\DriverListData.ser");
    ArrayList<formula01Driver> Drivers = new ArrayList<formula01Driver>();
    ArrayList<formula01Driver> deserializedDriversList;
    ArrayList<formula01Driver> previousRecordsList;
    ArrayList<formula01Driver> temp;
    ArrayList<car> CarTeams = new ArrayList<car>();

    Scanner sc = new Scanner(System.in);
    date dateoftheRace;


    //-----------add Driver method ----------------------------------------//
    public void addDriver() {
        car team = new car(teamName);
        formula01Driver driver = new formula01Driver(name, location, team, totalFirstPositions, totalSecondPositions, totalThirdPositions, totalPointsGained, totalRacesParticipated);
        Drivers.add(driver);
        CarTeams.add(team);
        System.out.println("Driver added to the list");
        for (int i = 0; i < Drivers.size(); i++) {

            System.out.println(Drivers.get(i));
        }
        for (int i = 0; i < CarTeams.size(); i++) {
            System.out.println(CarTeams.get(i));
        }
    }
    //---------------------------------------------------------------------//

    //----------Delete Driver and team-------------------------------------//
    public  ArrayList<formula01Driver> deleteDriver(){
        for (int i = 0 ; i<this.Drivers.size();i++){
            if(this.Drivers.get(i).getTeam().getCarName().equals(teamName) && this.Drivers.get(i).getName().equals(name) ){
                this.Drivers.remove(i);
                /*Drivers.get(i).setName("");
                Drivers.get(i).setLocation("");
                Drivers.get(i).getTeam().setCarName("");*/
            }
        }
        /*for(int i=0; i<Drivers.size();i++){
            System.out.println(Drivers.get(i));
        }*/
        return Drivers;


    }
    //---------------------------------------------------------------------//

    //-----------Delete team ---------------------------------------------//
    public ArrayList<car> deleteTeam(){
        for (int i = 0 ; i<CarTeams.size();i++){
            if(CarTeams.get(i).getCarName().equals(teamName) ){
                CarTeams.remove(i);
                /*Drivers.get(i).setName("");
                Drivers.get(i).setLocation("");
                Drivers.get(i).getTeam().setCarName("");*/
            }

        }

        for(int i=0; i<CarTeams.size();i++){
            System.out.println(CarTeams.get(i));
        }
        return CarTeams;
    }
    //--------------------------------------------------------------------//

    //---------------add driver to a existing team-------------------------//
    public ArrayList<formula01Driver> addDriverExistingTeam(){
        for (int i=0 ; i<CarTeams.size(); i++){
            if(CarTeams.get(i).getCarName().equals(teamName)){
                newTeam = CarTeams.get(i);

            }
        }
        for (int i = 0 ; i<Drivers.size();i++){
            if(Drivers.get(i).getTeam().getCarName().equals(newTeam) ){
                Drivers.remove(i);
                System.out.println(Drivers.get(i));
                /*Drivers.get(i).setName("");
                Drivers.get(i).setLocation("");
                Drivers.get(i).getTeam().setCarName("");*/
            }
        }
        for (int i = 0 ; i<Drivers.size();i++){
            if(Drivers.get(i).getTeam().getCarName().equals(currentTeam) && Drivers.get(i).getName().equals(name) ){
                Drivers.get(i).setTeam(newTeam);
                System.out.println(Drivers.get(i));
                /*Drivers.get(i).setName("");
                Drivers.get(i).setLocation("");
                Drivers.get(i).getTeam().setCarName("");*/
            }
        }
        for(int i=0; i<CarTeams.size();i++){
            System.out.println(CarTeams.get(i));
        }
        for(int i=0; i<Drivers.size();i++){
            System.out.println(Drivers.get(i));
        }
        return Drivers;

    }
    //---------------------------------------------------------------------//

    //---------------Display driver console columns-------------------------//
    public void consoleDriverTable(){
        Collections.sort(Drivers);
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n","Name","Team","Location","First Positions","Second Positions","Third Positions","Total Points","Total Races Participated");


        for(int i = 0; i< Drivers.size(); i++){
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",Drivers.get(i).getName(),Drivers.get(i).getTeam(),Drivers.get(i).getLocation(),Drivers.get(i).getTotalFirstPositions(),Drivers.get(i).getTotalSecondPositions(),Drivers.get(i).getTotalThirdPositions(),Drivers.get(i).getTotalPointsGained(),Drivers.get(i).getTotalRacesParticipated());
        }
    }
    //-----------------------------------------------------------------------//

    //---------------check statistics of a driver--------------------------//
    public void statistics(){
        for (int i = 0 ; i<Drivers.size();i++){
            if(Drivers.get(i).getTeam().getCarName().equals(currentTeam) && Drivers.get(i).getName().equals(name) ){

                System.out.println(Drivers.get(i).getName());
                System.out.println(Drivers.get(i).toString());
                /*Drivers.get(i).setName("");
                Drivers.get(i).setLocation("");
                Drivers.get(i).getTeam().setCarName("");*/
            }
        }
    }//----------------------------------------------------------------------//

    //-------Add race information to the main driver list-------------------------------------------//
    public void addRace(String teamName, int position){
        //create a car team object
        car contestentTeam = new car(teamName);
        //create a contestant object
        contestantDriver contestDriv = new contestantDriver(contestentTeam,position);
        //create a race object and push the contestant object into the race array inside race object
        race race = new race(contestDriv);
        //iterate throughmain driver array and add positions to corresponding drivers
        for(int i=0;i<Drivers.size();i++){

            System.out.println("Entered inside loop");
            if(Drivers.get(i).getTeam().equals(contestentTeam)){
                System.out.println("condition checked");
                Drivers.get(i).addRaceInformation(position);


            }
        }
    }
    //----------------------------------------------------------------------------------------------//

    //-----add to file------------------------------------------------------------------------------//
    public void addtoFile(){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Drivers);
            oos.close();
            fos.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println("Data written to file");


    }
    //----------------------------------------------------------------------------------------------//

    //-----retrieve from file-----------------------------------------------------------------------//
    public ArrayList<formula01Driver> retrieveFromFile(){
        try{
            //    File file = new File("DriverListData.ser");
            FileInputStream fis =new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            deserializedDriversList=(ArrayList<formula01Driver>) ois.readObject();
            ois.close();
            fis.close();
            if(this.Drivers.size()==0){
                for (int i=0;i<deserializedDriversList.size();i++){
                    Drivers.add(deserializedDriversList.get(i));
                }
                for(int i=0; i<Drivers.size();i++){
                    System.out.println(Drivers.get(i));
                }
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException c){
            System.out.println("Class not found exception");
            c.printStackTrace();
        }
    /*    for (int i =0; i<deserializedDriversList.size();i++){
            System.out.println(deserializedDriversList.get(i));
        }*/
        this.consoleDriverTable();


        return deserializedDriversList;
    }//----------------------------------------------------------//

    public void retrievePreviousDetails(){
       ArrayList<formula01Driver> temp = this.retrieveFromFile();
       if(this.Drivers.size()==0){
           for (int i=0;i<temp.size();i++){
               Drivers.add(temp.get(i));
           }
       }
       for(int i=0; i<Drivers.size();i++){
           System.out.println(Drivers.get(i));
        }

    }



    //-----------display gui------------------------------------------------------------------------//
    public void displayGUI(){
        gui guiTable = new gui("Table");
        guiTable.setVisible(true);
    }//----------------------------------------------------------------------------------------------//





// -------- menu -------------------------------------------------------//
    public void menu() {
        boolean goOn = true;
        while (goOn == true) {

            int input;

            System.out.println("This is from the menu method");

            System.out.println("Press 1 to add driver:");
            System.out.println("Press 2 to Delete Driver and team:");
            System.out.println("Press 3 to Change driver to existing team:");
            System.out.println("Press 4 to Check statistics of an existing driver:");
            System.out.println("Press 5 to display console table:");
            System.out.println("Press 6 to add race:");
            System.out.println("Press 7 to add to file");
            System.out.println("Press 8 to retrieve from file");
            System.out.println("Press 9 to retrieve previous details from file");
            System.out.println("Press 10 to open gui");
            System.out.println("Press 11 to stop");

            input = sc.nextInt();



            Scanner sc01 = new Scanner(System.in);
            switch (input) {


                case 1:
                    System.out.println("Enter driver name");
                    name = sc01.nextLine();
                    System.out.println("Enter Location:");
                    location = sc01.nextLine();
                    System.out.println("Enter team Name:");
                    teamName = sc01.nextLine();


                    System.out.println("Enter total first positions:");
                    totalFirstPositions = sc.nextInt();
                    System.out.println("Enter total second positions:");
                    totalSecondPositions = sc.nextInt();
                    System.out.println("Enter total third positions:");
                    totalThirdPositions = sc.nextInt();
                    System.out.println("Enter total points goined:");
                    totalPointsGained = sc.nextInt();
                    System.out.println("Enter total races participated:");
                    totalRacesParticipated = sc.nextInt();



                    addDriver();

                    break;

                case 2:
                    System.out.println("Enter driver name");
                    name = sc01.nextLine();
                    deleteDriver();
                    System.out.println("Do you need to delet the team? (Y/N)");
                    String choise = sc01.nextLine();
                    if (choise.equals("Y")|| choise.equals("y")) {
                        System.out.println("Enter team Name:");
                        teamName = sc01.nextLine();
                        CarTeams=deleteTeam();
                    }
                    for(int i=0; i<CarTeams.size();i++){
                        System.out.println(CarTeams.get(i));
                    }
                    Drivers=deleteDriver();
                    consoleDriverTable();
                    break;

                case 3:
                    System.out.println("Enter name of the driver:");
                    name = sc01.nextLine();
                    System.out.println("Enter Current team name:");
                    currentTeam = sc01.nextLine();
                    System.out.println("Enter new team name to transfer:");
                    teamName = sc01.nextLine();
                    Drivers=addDriverExistingTeam();


                    break;

                case 4:
                    System.out.println("Enter name of the driver:");
                    name = sc01.nextLine();
                    System.out.println("Enter Current team name:");
                    currentTeam = sc01.nextLine();
                    statistics();
                    break;

                case 5:
                    consoleDriverTable();
                    break;



                case 6:
                //    Scanner sc02 = new Scanner(System.in);
                    for(int i=0; i<3;i++){
                        System.out.println("Enter the Team Name:");
                        String contestentteamName = sc01.nextLine();
                        sc01.nextLine();
                        System.out.println("Position :");
                        Position=Integer.parseInt(sc01.nextLine());
                        addRace(contestentteamName,Position);
                    }
                    for(int i=0; i<Drivers.size();i++){
                        System.out.println(Drivers.get(i));
                    }
                    break;
                case 7:
                    addtoFile();
                    break;
                case 8:
                    retrieveFromFile();
                    break;

                case 9:
                    retrieveFromFile();
                    displayGUI();
                /*    DriversGuiTable table = new DriversGuiTable();
                    for(int i =0;i<table.DriversList.size();i++){
                        System.out.println(table.DriversList.get(i));
                    }*/
                    break;

                case 10:
                    goOn = false;
                    break;
            }

        }
    }



}//----------------------------------------------------------------------------------------------------------------//
