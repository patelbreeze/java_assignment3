/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication_mvc;

/**
 *
 * @author Breeze
 */
public class LunarRoverControlUnit {

    // Define the states
    public enum State {
        IDLE, COLOR_CAMERA_MODE, MM16_CAMERA_MODE, DRILL_MODE, TEMPORIZER_MODE
    }

    private State currentState = State.IDLE;

    // Variables to track button presses and timers
    private long button1PressTime = 0;
    private long temporizerTimer = 0;
    private boolean drillOn = false;

    public void pressButton1twice() {
        if (currentState == State.IDLE) {
            currentState = State.DRILL_MODE;
            // Toggle the drill on/off in drill mode
        }
    }

    public void pressButton1() {
        if (currentState == State.DRILL_MODE) {
            // Toggle the drill on/off in drill mode
            toggleDrill();
        } else if (currentState == State.COLOR_CAMERA_MODE) {
            // Take a picture in color camera mode
            takePicture();
        } else if (currentState == State.MM16_CAMERA_MODE) {
            // Take a picture in 16-mm camera mode
            takePicture();
        } else if (currentState == State.TEMPORIZER_MODE) {
            // Take a picture in TEMPORIZER_MODE
            takePicture();
        }
    }

    public void pressButton1ForFiveSeconds() {
        if (currentState == State.IDLE) {
            // Transition to color camera mode
            currentState = State.COLOR_CAMERA_MODE;
            button1PressTime = System.currentTimeMillis();
        } else if (currentState == State.COLOR_CAMERA_MODE) {
            // activateTemporizer moon selfie in color camera mode
            activateTemporizer();
        } else if (currentState == State.MM16_CAMERA_MODE) {
            // activateTemporizer moon selfie in 16-mm camera mode
            activateTemporizer();
        }

    }

    public void pressButton1ForTenSeconds() {
        if (currentState == State.IDLE) {
            // Transition to 16-mm camera mode
            currentState = State.MM16_CAMERA_MODE;
            button1PressTime = System.currentTimeMillis();
        }
    }

    public void pressButton2() {
        if (currentState == State.COLOR_CAMERA_MODE || currentState == State.MM16_CAMERA_MODE || currentState == State.TEMPORIZER_MODE) {
            // Return to idle state
            currentState = State.IDLE;
            button1PressTime = 0;
        }
    }

    private void takePicture() {
        if (currentState == State.COLOR_CAMERA_MODE || currentState == State.MM16_CAMERA_MODE || currentState == State.TEMPORIZER_MODE) {
            System.out.println("Taking a picture.");
        }
    }

    private void toggleDrill() {
        if (currentState == State.DRILL_MODE) {
            drillOn = !drillOn;
            System.out.println("Drill is " + (drillOn ? "ON" : "OFF"));
        }
    }

    private void activateTemporizer() {
        if (currentState == State.COLOR_CAMERA_MODE || currentState == State.MM16_CAMERA_MODE) {
            temporizerTimer = System.currentTimeMillis();
            currentState = State.TEMPORIZER_MODE;
        }
    }

    public static void main(String[] args) {
        System.out.println("BREEZE PATEL || NEU ID: 002821278");
        System.out.println("---------------------------");

        LunarRoverControlUnit rover = new LunarRoverControlUnit();

        // Simulate pressing button 1 for five seconds in the idle state to interact with the color camera
        rover.pressButton1ForFiveSeconds();
        System.out.println("Current State: " + rover.currentState);
        // to capture picture
        rover.pressButton1();
        System.out.println("---------------------------");

        // Simulate pressing button 2 to return to idle state from color camera mode
        rover.pressButton2();
        System.out.println("Current State: " + rover.currentState);
        System.out.println("---------------------------");

        // Simulate pressing button 1 for ten seconds in the idle state to interact with the 16-mm camera
        rover.pressButton1ForTenSeconds();
        System.out.println("Current State: " + rover.currentState);
        // to capture picture
        rover.pressButton1();
        System.out.println("---------------------------");

        // Simulate pressing button 2 to return to idle state from 16-mm camera mode
        rover.pressButton2();
        System.out.println("Current State: " + rover.currentState);
        System.out.println("---------------------------");

        rover.pressButton1ForTenSeconds();
        System.out.println("Current State: " + rover.currentState);
        // TEMPORIZER_MODE 
        rover.pressButton1ForFiveSeconds();
        System.out.println("Current State: " + rover.currentState);
// to capture picture
        rover.pressButton1();
        System.out.println("---------------------------");

        // Simulate pressing button 2 to return to idle state from 16-mm camera mode
        rover.pressButton2();
        System.out.println("Current State: " + rover.currentState);
        System.out.println("---------------------------");

        // Simulate pressing button 1 twice in the idle state to enter the drill mode and toggle the drill on/off
        rover.pressButton1twice();
        System.out.println("Current State: " + rover.currentState);
        // Simulate pressing button 1 to toggle drill mode
        rover.pressButton1();
        // Simulate pressing button 1 to toggle drill mode
        rover.pressButton1();
        System.out.println("---------------------------");

    }
}
