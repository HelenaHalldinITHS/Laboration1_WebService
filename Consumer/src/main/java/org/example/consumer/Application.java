package org.example.consumer;

import org.example.converter.KiloConverter;

import java.util.List;
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
        List<KiloConverter> converters = serviceLoader.stream().map(ServiceLoader.Provider::get).toList();

        while (true) {
            double weightInKg = getWeightToConvert();
            int choice = getChoice(converters);
            if (choice == 0)
                break;
            KiloConverter converter = converters.get(choice - 1);
            printWeight(converter, weightInKg);
        }
    }

    private double getWeightToConvert() {
        print("Enter the weight you want to convert (in kg): ");
        return Double.parseDouble(getStringInput());
    }

    private int getChoice(List<KiloConverter> converters) {
        print("Enter the number corresponding to the choice you want to make.\n" +
                "Available options are:");
        printChoices(converters);
        return Integer.parseInt(getStringInput());
    }

    private void printChoices(List<KiloConverter> converters) {
        print("0. Exit");
        for (int i = 0; i < converters.size(); i++) {
            print(i + 1 + ". " + converters.get(i).description());
        }
    }

    private void printWeight(KiloConverter converter, double weightInKg) {
        print(converter.convert(weightInKg) + " " + converter.getSymbol());
    }

    private void print(String s) {
        System.out.println(s);
    }

    private String getStringInput() {
        return scanner.nextLine();
    }

}
