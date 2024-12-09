package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Reference
// https://github.com/logued/oop-queue-linkedlist/blob/master/src/main/java/dkit/oop/App.java
/**
 *  Name: Sahil Samuel
 *  Class Group: SD2A
 */
public class Question7  // Shares Tax Calculations (Queue)
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args)
    {
        System.out.print("Enter command (buy/sell/quit): ");
        Queue<Block> shares = new LinkedList<>();
       Scanner in = new Scanner(System.in);
        String command="";
            do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                shares.add(new Block(qty, price)); // Adds a new block to the queue
                System.out.println("Bought " + qty + " shares for $ " + price);
            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                double totalProfit = 0;
                int remainingSharesToSell = qty;

                while (remainingSharesToSell > 0 && !shares.isEmpty())
                {
                        Block currentBlock = shares.remove();// Removes the block from the front of the queue
                    if (currentBlock != null)
                    {
                        if (currentBlock.getQuantity() <= remainingSharesToSell) {
                            double profit = (price - currentBlock.getPrice()) * currentBlock.getQuantity();
                            totalProfit += profit;
                            remainingSharesToSell -= currentBlock.getQuantity();
                            System.out.println("Sold " + currentBlock.getQuantity() + " shares for $ " + profit + " with a profit of $ " + String.format("%.2f", totalProfit));
                        } else {
                            double profit = (price - currentBlock.getPrice()) * currentBlock.getQuantity();
                            totalProfit += profit;
                            System.out.println("Sold " + currentBlock.getQuantity() + " shares for $ " + profit + " with a profit of $ " + String.format("%.2f", totalProfit));


                            //updating the remaing shares in the block
                            currentBlock.setQuantity(currentBlock.getQuantity() - remainingSharesToSell);
                            shares.add(currentBlock); // This adds the remaining block back to the queue
                            remainingSharesToSell = 0;
                        }
                    }
                }

                if (remainingSharesToSell > 0)
                {
                    System.out.println("Warning: Not enough shares to sell!");
                } else
                {
                    System.out.println("Total gain: $" + String.format("%.2f", totalProfit));
                }
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}