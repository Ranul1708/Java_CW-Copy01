import java.util.ArrayList;

/*
* holds the abstract methods for formula01ChampionshipManagerClass
* */
public interface championshipManager{

    void addDriver();
    ArrayList<formula01Driver> deleteDriver();
    ArrayList<car> deleteTeam();
    ArrayList<formula01Driver> addDriverExistingTeam();

    void menu();


}
