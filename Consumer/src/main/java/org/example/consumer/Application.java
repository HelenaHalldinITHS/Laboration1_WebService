package org.example.consumer;

import org.example.converter.KiloConverter;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Application {
    private final Scanner scanner = new Scanner(System.in);
    private final ServiceLoader<KiloConverter> serviceLoader = ServiceLoader.load(KiloConverter.class);

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        double weightInKg = getWeightToConvert();
        switch (getUnitChoice()) {
            case 1 -> printWeight(weightInKg, "Pounds");
            case 2 -> printWeight(weightInKg, "Stone");
            default -> print("Invalid input");
        }
    }

    private int getUnitChoice() {
        print("""
                Enter the number corresponding to the unit you want to convert to:
                1. Pound
                2. Stone
                """);
        return Integer.parseInt(getStringInput());
    }

    private double getWeightToConvert() {
        print("Enter the weight you want to convert (in kg): ");
        return Double.parseDouble(getStringInput());
    }

    private void printWeight(double weightInKg, String unit) {
        serviceLoader.stream()
                .filter(provider -> provider.type().getSimpleName().contains(unit))
                .map(ServiceLoader.Provider::get)
                .forEach(converter -> printWeightWithSymbol(converter, weightInKg));
    }

    private void printWeightWithSymbol(KiloConverter converter, double weightInKg) {
        print(converter.convert(weightInKg) + " " + converter.getSymbol());
    }

    private void print(String s) {
        System.out.println(s);
    }

    private String getStringInput() {
        return scanner.nextLine();
    }

}
