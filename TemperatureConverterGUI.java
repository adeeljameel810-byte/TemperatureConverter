package com.tempconverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI for the temperature converter.
 * Demonstrates Inheritance (extends JFrame) and Encapsulation.
 */
public class TemperatureConverterGUI extends JFrame {
    // Encapsulated components
    private JTextField inputField;
    private JComboBox<String> fromUnitBox;
    private JComboBox<String> toUnitBox;
    private JButton convertButton;
    private JTextField outputField;
    private TemperatureConverter converter;

    public TemperatureConverterGUI() {
        converter = new TemperatureConverter();
        initializeComponents();
        setupLayout();
        addListeners();
        setAppearance();
    }

    private void initializeComponents() {
        inputField = new JTextField(10);
        fromUnitBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        toUnitBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        convertButton = new JButton("Convert");
        outputField = new JTextField(10);
        outputField.setEditable(false);
    }

    private void setupLayout() {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Input Temperature:"), gbc);

        gbc.gridx = 1;
        add(inputField, gbc);

        gbc.gridx = 2;
        add(fromUnitBox, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Convert to:"), gbc);

        gbc.gridx = 1;
        add(toUnitBox, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        add(convertButton, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Result:"), gbc);

        gbc.gridx = 1;
        add(outputField, gbc);

        pack();
        setLocationRelativeTo(null);
    }

    private void addListeners() {
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double value = Double.parseDouble(inputField.getText());
                    String fromUnit = (String) fromUnitBox.getSelectedItem();
                    String toUnit = (String) toUnitBox.getSelectedItem();
                    double result = converter.convert(value, fromUnit, toUnit);
                    outputField.setText(String.format("%.2f", result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TemperatureConverterGUI.this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void setAppearance() {
        // Make it attractive
        getContentPane().setBackground(new Color(240, 248, 255)); // Alice blue
        convertButton.setBackground(new Color(70, 130, 180)); // Steel blue
        convertButton.setForeground(Color.WHITE);
        convertButton.setFocusPainted(false);
        Font font = new Font("Arial", Font.PLAIN, 14);
        inputField.setFont(font);
        outputField.setFont(font);
        fromUnitBox.setFont(font);
        toUnitBox.setFont(font);
        convertButton.setFont(font);
    }
}