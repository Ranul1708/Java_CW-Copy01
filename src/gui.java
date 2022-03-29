/*
* Creates the GUI
* */

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends JFrame implements ActionListener {
    private DriversGuiTable tableModel;
    private JTable table;
    public formula01ChampionshipManager mgr=new formula01ChampionshipManager();

    public gui(String title){
        super(title);
        setBounds(10,10,600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  tableModel=new DriversGuiTable(mgr);
        tableModel=new DriversGuiTable(mgr);
        table = new JTable(tableModel);

        /*Code for sorting the rows*/
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setPreferredSize(new Dimension(500,500));
        JPanel tablepanel = new JPanel();
        tablepanel.add(scrollPane);
        add(tablepanel,BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent ae){

    }


}
