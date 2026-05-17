package com.tempconverter;

/**
 * Interface for temperature conversion operations.
 * Demonstrates Abstraction pillar of OOP.
 */
public interface Convertible {
    /**
     * Converts the given temperature value.
     * @param value the temperature value to convert
     * @return the converted temperature value
     */
    double convert(double value);
}