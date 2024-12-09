package org.example;

public class Pyramid implements IMeasurableContainer
{
    private final double length;
    private final double sideLength;
    private final double weight;

    public Pyramid(double length, double sideLength, double weight) {
        this.length = length;
        this.sideLength = sideLength;
        this.weight = weight;
    }

    @Override
    public double weight() { return weight; }

    @Override
    public double rectangularVolume() { return Math.pow(length, 3); }

    public double getLength() { return length; }
    public double getSideLength() { return sideLength; }
    public double getWeight() { return weight; }
}
