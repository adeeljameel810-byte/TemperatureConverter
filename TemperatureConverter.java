package com.tempconverter;

/**
 * Main temperature converter class that handles conversions between different units.
 * Demonstrates Encapsulation pillar of OOP by hiding the conversion logic.
 */
public class TemperatureConverter {
    // Encapsulated fields
    private Convertible converter;

    /**
     * Sets the converter based on from and to units.
     * @param fromUnit the unit to convert from
     * @param toUnit the unit to convert to
     */
    public void setConverter(String fromUnit, String toUnit) {
        if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) {
            converter = new CelsiusToFahrenheit();
        } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius")) {
            converter = new FahrenheitToCelsius();
        } else if (fromUnit.equals("Celsius") && toUnit.equals("Kelvin")) {
            converter = new CelsiusToKelvin();
        } else if (fromUnit.equals("Kelvin") && toUnit.equals("Celsius")) {
            converter = new KelvinToCelsius();
        } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Kelvin")) {
            // For Fahrenheit to Kelvin, first to Celsius then to Kelvin
            // But to keep simple, perhaps add direct classes, but for now, handle in convert method
            converter = null; // Will handle specially
        } else if (fromUnit.equals("Kelvin") && toUnit.equals("Fahrenheit")) {
            converter = null;
        } else {
            converter = null;
        }
    }

    /**
     * Converts the temperature value using the set converter.
     * @param value the value to convert
     * @param fromUnit from unit
     * @param toUnit to unit
     * @return converted value
     */
    public double convert(double value, String fromUnit, String toUnit) {
        setConverter(fromUnit, toUnit);
        if (converter != null) {
            return converter.convert(value);
        } else {
            // Handle indirect conversions
            if (fromUnit.equals("Fahrenheit") && toUnit.equals("Kelvin")) {
                // F to C to K
                double celsius = new FahrenheitToCelsius().convert(value);
                return new CelsiusToKelvin().convert(celsius);
            } else if (fromUnit.equals("Kelvin") && toUnit.equals("Fahrenheit")) {
                // K to C to F
                double celsius = new KelvinToCelsius().convert(value);
                return new CelsiusToFahrenheit().convert(celsius);
            } else {
                return value; // Same unit
            }
        }
    }
}