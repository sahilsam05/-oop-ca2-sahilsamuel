package org.example;

import java.util.Scanner;
/**
 *  Name: Sahil Samuel
 *  Class Group: SD2A
 */
public class Question7  // Shares Tax Calculations (Queue)
{

    private static Block[] shares = new Block[100];

    private static int count = 0;
    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {

       Scanner in = new Scanner(System.in);
        String command="";
            do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                shares[count++] = new Block(qty, price);
                System.out.println("Bought " + qty + " shares for $ " + price);
            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                double totalProfit = 0;
                int remainingSharesToSell = qty;

                for (int i = 0; i < count && remainingSharesToSell > 0; i++)
                {
                    Block currentBlock = shares[i];
                    if (currentBlock.getQuantity() > remainingSharesToSell)
                    {
                        double profit = (price - currentBlock.getPrice()) * currentBlock.getQuantity();
                        totalProfit += profit;
                        remainingSharesToSell -= currentBlock.getQuantity();
                        System.out.println("Sold " + currentBlock.getQuantity() + " shares for $ " + currentBlock.getPrice() + "with a profit of $ " + String.format("%.2f", profit));
                        shares[i] = null;
                    }
                }


            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}