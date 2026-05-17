package com.tempconverter;

/**
 * Converts Celsius to Kelvin.
 * Demonstrates Inheritance and Polymorphism pillars of OOP.
 */
public class CelsiusToKelvin implements Convertible {
    @Override
    public double convert(double celsius) {
        return celsius + 273.15;
    }
}