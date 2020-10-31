/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainactions;

import database.Values;
import static java.lang.Math.PI;

/**
 * This class carries out computation functions and saves them to static variables in Values
 * @author Cam
 */
public class Computation {
    
    //Degrees to radians calculation
    public void degreesToRad() {
        Values.setType("Radians");
        Values.setAnswer(Values.getDegrees() * (PI / 180));
        Values.setUnit("Rad");
    }
    
    //Accelleration calculation
    public void accelleration() {
        Values.setType("Linear Accelleration");
        Values.setAnswer((Values.getFinalVel() - Values.getInitalVel()) / (Values.getFinalTime() - Values.getInitialTime()));
        Values.setUnit("m/s");
    }
    
    //Kinetic energy calculation
    public void kineticKenergy() {
        Values.setType("Linear Kinetic Energy");
        Values.setAnswer(0.5 * Values.getMass() * (Values.getVelocity() * Values.getVelocity()));
        Values.setUnit("J");
    }
    
    //Angular Force calculation
    public void angularForce() {
        Values.setType("Angular Force");
        Values.setAnswer(Values.getMass() * Values.getRadius() * (Values.getAngVelocity() * Values.getAngVelocity()));
        Values.setUnit("N");
    }
    
}
