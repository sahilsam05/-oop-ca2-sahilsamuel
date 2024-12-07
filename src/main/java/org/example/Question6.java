package org.example;

import java.util.PriorityQueue;

/**
 *  Name: Sahil Samuel
 *  Class Group: SD2A
 */

public class Question6      // Flight take-off (Queue)
{
    public static void main(String[] args)
    {

    }

    public void takeoff(String flightCode) {
        takeoffQueue.add(new Plane(flightCode));
        System.out.println(flightCode + " is queued for takeoff.");
    }

    public void land(String flightCode) {
        landingQueue.add(new Plane(flightCode));
        System.out.println(flightCode + " is queued for landing.");
    }

    public void next() {
        if (!landingQueue.isEmpty()) {
            Plane flight = landingQueue.poll();
            System.out.println("Landing " + flight.getFlightCode());
        } else if (!takeoffQueue.isEmpty()) {
            Plane flight = takeoffQueue.poll();
            System.out.println("Taking off " + flight.getFlightCode());
        } else {
            System.out.println("No planes waiting.");
        }
}
