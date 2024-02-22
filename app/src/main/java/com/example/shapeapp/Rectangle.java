package com.example.shapeapp;

public class Rectangle implements Shape{
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width*height;
    }

    @Override
    public double perimeter() {
        return 2*(width+height);
    }
}
