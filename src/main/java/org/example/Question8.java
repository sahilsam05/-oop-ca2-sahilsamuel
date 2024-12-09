package org.example;

// Reference
// https://github.com/logued/oop-maps-demo-2022/blob/master/src/main/java/AppMainMapsDemo.java
// https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/

import java.util.*;
/**
 *  Name: Sahil Samuel
 *  Class Group: SD2A
 */
public class Question8  // Multi-company (Queue)
{
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Map<String, Queue<Block>> sharesMap = new HashMap<String, Queue<Block>>();
        String command="";
        do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to buy shares here
                sharesMap.putIfAbsent(company, new LinkedList<>());
                sharesMap.get(company).add(new Block(qty, price));
                System.out.println(company + " bought " + qty + " " + price);
            }
            else if(command.equals("sell"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                double totalProfit = 0;
                // Code to sell shares and calculate profit here
                Queue<Block> companyShares = sharesMap.get(company); // Get the queue for the company
                if (companyShares == null || companyShares.isEmpty())
                {
                    System.out.println("No shares available");
                    return;
                }

                while(qty > 0 && !companyShares.isEmpty())
                {
                    Block b = companyShares.remove();
                    if (b != null) {
                        if (b.getQuantity() <= qty) {
                            double profit = (price * b.getPrice()) / b.getQuantity();
                            totalProfit += profit;
                            System.out.println(company + " bought " + qty + " " + profit);

                            b.setQuantity(b.getQuantity() - qty);
                            companyShares.add(b);
                            qty = 0;

                        }
                    }
                }
                if (qty == 0)
                {
                    System.out.println("No shares available");
                }
                else
                {
                    System.out.println("Total profit: " + String.format("%.2f", totalProfit));
                }
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}
