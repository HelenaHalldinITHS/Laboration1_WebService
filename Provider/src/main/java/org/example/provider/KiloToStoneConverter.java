package org.example.provider;

import org.example.converter.KiloConverter;
import org.example.converter.WeightConverter;

@WeightConverter(goalUnit = "stone", startUnit = "kilo")
public class KiloToStoneConverter implements KiloConverter {
    @Override
    public double convert(double kg) {
        return kg * 0.15747;
    }

    @Override
    public String getSymbol() {
        return "st";
    }

    @Override
    public String getDescription() {
        return "Convert kilo to stone";
    }
}
