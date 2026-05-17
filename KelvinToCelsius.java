package com.tempconverter;

/**
 * Converts Kelvin to Celsius.
 * Demonstrates Inheritance and Polymorphism pillars of OOP.
 */
public class KelvinToCelsius implements Convertible {
    @Override
    public double convert(double kelvin) {
        return kelvin - 273.15;
    }
}