package com.epam.assessment.cars.logic;

import com.epam.assessment.cars.domain.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ModelsCollection {
    private final List<Model> models = new ArrayList<>();

    public void readFromFile(String filePath) {
        try {
            Files.lines(Path.of(filePath))
                    .map(ModelParser::parse)
                    .forEach(models::add);
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while reading file: " + e.getMessage(), e);
        }
    }

    public Optional<Model> getModel(String manufacturer, String modelName) {
        return models.stream()
                .filter(m -> m.getManufacturer().equals(manufacturer)
                        && m.getModelName().equals(modelName))
                .findFirst();
    }

    public List<ElectricModel> getElectricModelsByBatteryCapacity(int capacityLimit) {
        return models.stream()
                .filter(m -> m instanceof ElectricModel)
                .map(m -> (ElectricModel) m)
                .filter(em -> em.getBatteryCapacity() >= capacityLimit)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Model> getAllModels() {
        return Collections.unmodifiableList(models);
    }
}
