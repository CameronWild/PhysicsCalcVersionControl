/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;

/**
 * Static class for data access in any class. Learned how to use late into program which is
 * why some variables aren't here yet.
 * @author Cam
 */
public class Values {
    
    // Variables
    static double mass, degrees, radius, angVelocity, velocity, initalVel, initialTime,
            finalVel, answer, finalTime = 0;
    static String unit, type, username = "";
    static ArrayList<String> readData = new ArrayList<String>();
    
    // Getters and Setters 
    public static ArrayList<String> getReadData() {
        return readData;
    }

    public static void setReadData(ArrayList<String> readData) {
        Values.readData = readData;
    }


    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Values.username = username;
    }
    static String url = "jdbc:derby:CalculatorDB; create=true;";

    public static String getUnit() {
        return unit;
    }

    public static void setUnit(String unit) {
        Values.unit = unit;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Values.type = type;
    }

    public static double getAnswer() {
        return answer;
    }

    public static void setAnswer(double answer) {
        Values.answer = answer;
    }

    public static double getMass() {
        return mass;
    }

    public static void setMass(double mass) {
        Values.mass = mass;
    }

    public static double getDegrees() {
        return degrees;
    }

    public static void setDegrees(double degrees) {
        Values.degrees = degrees;
    }

    public static double getRadius() {
        return radius;
    }

    public static void setRadius(double radius) {
        Values.radius = radius;
    }

    public static double getAngVelocity() {
        return angVelocity;
    }

    public static void setAngVelocity(double angVelocity) {
        Values.angVelocity = angVelocity;
    }

    public static double getVelocity() {
        return velocity;
    }

    public static void setVelocity(double velocity) {
        Values.velocity = velocity;
    }

    public static double getInitalVel() {
        return initalVel;
    }

    public static void setInitalVel(double initalVel) {
        Values.initalVel = initalVel;
    }

    public static double getInitialTime() {
        return initialTime;
    }

    public static void setInitialTime(double initialTime) {
        Values.initialTime = initialTime;
    }

    public static double getFinalVel() {
        return finalVel;
    }

    public static void setFinalVel(double finalVel) {
        Values.finalVel = finalVel;
    }

    public static double getFinalTime() {
        return finalTime;
    }

    public static void setFinalTime(double finalTime) {
        Values.finalTime = finalTime;
    }

}
