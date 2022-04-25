package org.example.provider;

import org.example.converter.KiloConverter;
import org.example.converter.WeightConverter;

@WeightConverter(goalUnit = "pounds", startUnit = "kilo")
public class KiloToPoundsConverter implements KiloConverter {
    @Override
    public double convert(double kg) {
        return kg * 2.2046;
    }

    @Override
    public String getSymbol() {
        return "lb";
    }

    @Override
    public String getDescription() {
        return "Convert kilo to pounds";
    }
}
