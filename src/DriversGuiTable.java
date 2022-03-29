/*
 * This class extends the Abstract table model
 * here all the methods for abstract table is implemented
 * This class has a constructor, which takes the arraylist of books
 * And by that, is how the data to populate the table will be provided.
 * The code for this part of was taken from the internet (URL:  http://www2.hawaii.edu/~takebaya/ics111/jtable_custom/jtable_custom.html)
 * */
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Objects;


public class DriversGuiTable extends AbstractTableModel  {

    //list of columns
    private String[] columnNames = {"Team", "Name", "Total Points", "firstPositions","Second Positions","Third Positions","Total Races"};
    //Official array for the table-unique for this class
   ArrayList<formula01Driver> DriversList;
    public formula01ChampionshipManager mgr=new formula01ChampionshipManager();



    //constructor of this class-takes object of formula01manage object, than reaches it's Drivers array
    //then creates a reference to that array calles "Drivers list" so it's accessible


    public DriversGuiTable(formula01ChampionshipManager mgr){
        DriversList = mgr.deserializedDriversList;
    }


    //Implementation of the AbstractTableModel Methods
    /*
    * getColumnCount()
    * getRowCount()
    * getValueAt(int row,int col)
    * getColumnName()
    * getColumnClass(int col)
    * */
    public int getColumnCount(){
        //returns the number of total columns
        return columnNames.length;
    }
    //---------------------------------------------------------------//
    public int getRowCount(){
        //returns the number of rows to the tablel
        /*
        int size;
        if(DriversList==null){
            size = 0;
        }else{
            size=DriversList.size();
        }
        return size;*/
        return mgr.retrieveFromFile().size();
    }//---------------------------------------------------------------//

    public Object getValueAt(int row, int col){
        //links each cell of the row in the table with corrosponding values of the drivers
         switch (col){
            /*case 0->DriversList.get(row).getTeam();
            case 1->DriversList.get(row).getName();
            case 2->DriversList.get(row).getTotalPointsGained();
            case 3->DriversList.get(row).getTotalFirstPositions();
            case 4->DriversList.get(row).getTotalSecondPositions();
            case 5->DriversList.get(row).getTotalThirdPositions();
            case 6->DriversList.get(row).getTotalRacesParticipated();
            default -> "-";*/
            case 0:return mgr.retrieveFromFile().get(row).getTeam();
            case 1:return mgr.retrieveFromFile().get(row).getName();
            case 2:return mgr.retrieveFromFile().get(row).getTotalPointsGained();
            case 3:return mgr.retrieveFromFile().get(row).getTotalFirstPositions();
            case 4:return mgr.retrieveFromFile().get(row).getTotalSecondPositions();
            case 5:return mgr.retrieveFromFile().get(row).getTotalThirdPositions();
            case 6:return mgr.retrieveFromFile().get(row).getTotalRacesParticipated();
            default :return  "-";
         }
    }//------------------------------------------------------------------//

    public String getColumnName(int col){return  columnNames[col];}
   public Class<?> getColumnClass(int col){
        if(getValueAt(0,col)!=null){
            return getValueAt(0,col).getClass();
        }else {
            return Object.class;
        }

    }



}
