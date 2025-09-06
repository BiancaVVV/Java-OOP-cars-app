package com.epam.assessment.cars.logic;

import com.epam.assessment.cars.domain.*;

public class ModelParser {

    public static Model parse(String line) {
        String[] parts = line.split(",");

        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid line: " + line);
        }

        String type = parts[0];
        switch (type) {
            case "Regular":
                if (parts.length != 6) {
                    throw new IllegalArgumentException(
                            "Invalid number of parameters. Expected 6, received: " + parts.length
                    );
                }
                return new RegularModel(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]),
                        Double.parseDouble(parts[5])
                );

            case "Electric":
                if (parts.length != 6) {
                    throw new IllegalArgumentException(
                            "Invalid number of parameters. Expected 6, received: " + parts.length
                    );
                }
                return new ElectricModel(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5])
                );

            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
