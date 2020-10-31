/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainactions;

import database.SaveData;
import database.Values;

/**
 * This class runs two threads which calculate and then save data.
 * Probably not quite necessary, need more error checking to be see if useful.
 * @author Cam
 */
public class SolveAndSaveThread {

    Computation calculateAns = new Computation();

    public SolveAndSaveThread(String equation) throws InterruptedException {

        String eq = equation;
        
        //Calculation thread
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    calculate(eq);
                    System.out.println(Values.getAnswer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        //Save thread
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    save();
                } catch (InterruptedException e) {
                    System.out.println("Error in thread 2");
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    //Detects what calculation to carry out
    public void calculate(String eq) throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this) {
            if (eq.equals("Degrees")) {
                calculateAns.degreesToRad();
            } else if (eq.equals("Angular Force")) {
                calculateAns.angularForce();
            } else if (eq.equals("Kinetic Energy")) {
                calculateAns.kineticKenergy();
            } else if (eq.equals("Accelleration")) {
                calculateAns.accelleration();
            } else {
                System.out.println("Error in Equation Input(Solve and Save calculate method)");
            }

            notify();
        }
    }
    
    //Detects if should save or not 
    public void save() throws InterruptedException {

        synchronized (this) {
            wait();

            if (!Values.getUsername().equals("guest")) {
                SaveData saveAction = new SaveData();
            } else {
                System.out.println("Guest Account: no saving");
            }

        }
    }
}
