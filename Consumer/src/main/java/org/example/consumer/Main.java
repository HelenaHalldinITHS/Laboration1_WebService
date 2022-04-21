package org.example.consumer;

import org.example.converter.KiloConverter;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<KiloConverter> serviceLoader = ServiceLoader.load(KiloConverter.class);

        for (KiloConverter converter : serviceLoader){
            System.out.println(converter.convert(1.0));
        }
    }
}
