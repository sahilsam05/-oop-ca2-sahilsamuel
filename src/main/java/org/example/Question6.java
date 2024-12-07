package org.example;

// Reference
// https://github.com/logued/oop-priority-queue-demo/blob/master/src/main/java/dkit/oop/MainApp.java

import java.util.PriorityQueue;

/**
 *  Name: Sahil Samuel
 *  Class Group: SD2A
 */

public class Question6      // Flight take-off (Queue)
{
    public static void main(String[] args)
    {
        takeoff("TK1212");
        land("TK131");
    }



    public static void takeoff(String flightCode)
    {
        PriorityQueue<String> takeoffQueue = new PriorityQueue<>();
        takeoffQueue.add(flightCode);
        System.out.println(flightCode + " is queued for takeoff.");
    }

    public static void land(String flightCode)
    {
        PriorityQueue<String> landingQueue = new PriorityQueue<>();

        landingQueue.add(flightCode);
        System.out.println(flightCode + " is queued for landing.");
    }

    public void next() {
        if (land(""))
        {
            Plane flight = landingQueue.poll();
            System.out.println("Landing " + flight.getFlightCode());
        } else if (!takeoffQueue.isEmpty()) {
            Plane flight = takeoffQueue.poll();
            System.out.println("Taking off " + flight.getFlightCode());
        } else {
            System.out.println("No planes waiting.");
        }
    }
}
