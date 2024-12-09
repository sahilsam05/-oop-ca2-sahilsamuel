package org.example;

import java.util.Scanner;
import java.util.Stack;


// Reference
// Last In First Out Video https://www.youtube.com/watch?v=ulKem8Bpw9M
/**
 *  Name: Sahil Samuel
 *  Class Group: SD2A
 */
public class Question2  // Car Parking - Stack
{
    public static void runSimulation()
    {
        Stack<Integer> driveway = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();

        Scanner keyboard = new Scanner(System.in);

        while (true)
        {
            System.out.print("Enter a number  (positive to park, negative to retrieve, 0 to exit) : ");
            int number = keyboard.nextInt();

            if  (number == 0)
            {
                System.out.println("Simulation ended! ");
            }
            else if(number > 0)
            {
                driveway.push(number);
                System.out.println("Car " + number + " parked.");
            }
            else
            {
                int targetCar = driveway.pop();
            }
        }

    }

    public static void main(String[] args) {
        runSimulation();
    }
}
