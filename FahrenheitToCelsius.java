package com.tempconverter;

/**
 * Converts Fahrenheit to Celsius.
 * Demonstrates Inheritance and Polymorphism pillars of OOP.
 */
public class FahrenheitToCelsius implements Convertible {
    @Override
    public double convert(double fahrenheit) {
        return (fahrenheit - 32) * 5.0/9.0;
    }
}