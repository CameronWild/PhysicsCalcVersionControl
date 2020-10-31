/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import database.ReadData;
import database.Values;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Iterator;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This panel reads the array list of saved data and loads onto panel
 * @author Cam
 */
public class SavedData extends JPanel{
    
    JLabel data;
    ReadData read;
    
    public SavedData(){
        
        read = new ReadData();
        String dataOutput = "";
        Iterator itr = Values.getReadData().iterator();
        
        while(itr.hasNext()){
            dataOutput = dataOutput + itr.next() + "\n";
        }
        
        String formated = dataOutput.replace("\n", "<br>");
        formated = "<html><div style ='text-align: center;'>" + formated + "</div></html>";
        data = new JLabel(formated);
        
        data.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.NORTH);
        add(data, BorderLayout.CENTER);
        
    }
    
}
