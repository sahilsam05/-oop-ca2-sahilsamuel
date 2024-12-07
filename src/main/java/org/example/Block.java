package org.example;

public class Block
{
    private int quantity;
    private double price;

    public Block(int quantity, double price)
    {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getPrice()
    {
        return price;
    }
}
