package org.example;

// Reference
// https://github.com/logued/oop-priority-queue-demo/blob/master/src/main/java/dkit/oop/MainApp.java
// https://github.com/logued/oop-queue-linkedlist/blob/master/src/main/java/dkit/oop/App.java

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Name: Sahil Samuel
 *  Class Group: SD2A
 */

public class Question6      // Flight take-off (Queue)
{

    Queue<String> takeoffQueue = new LinkedList<>();
    Queue<String> landingQueue = new LinkedList<>();

    public static void main(String[] args)
    {
        Question6 airport = new Question6();
        airport.takeoff("Flight - 100");
        airport.takeoff("Flight - 200");
        airport.land("Flight-320");
        airport.takeoff("Flight - E104");
        airport.next();
        airport.next();
    }



    public void takeoff(String flightCode)
    {
        takeoffQueue.add(flightCode);
        System.out.println(flightCode + " is queued for takeoff.");
    }

    public void land(String flightCode)
    {
        landingQueue.add(flightCode);
        System.out.println(flightCode + " is queued for landing.");
    }

    public void next() {
        if (landingQueue.isEmpty())
        {
            String flight = landingQueue.remove();
            System.out.println("Landing " + flight);
        } else if
        (!takeoffQueue.isEmpty())
        {
            String flight = takeoffQueue.remove();
            System.out.println("Taking off " + flight);
        } else
        {
            System.out.println("No planes waiting.");
        }
    }
}
