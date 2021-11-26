package com.dataart.itschool;

import java.util.Arrays;

public enum WeatherRange {
    HOT(31, 100, "ЖАРКО"),
    WARM(19, 30, "ТЕПЛО"),
    COOL(10, 18, "ПРОХЛАДНО"),
    COLD(0, 9, "ХОЛОДНО"),
    FREEZING(-100, 0, "МОРОЗ");

    private final int min;
    private final int max;
    private final String label;

    WeatherRange(int min, int max, String label) {
        this.min = min;
        this.max = max;
        this.label = label;
    }

    public static WeatherRange getByLabel(String weatherCondition) throws Exception {
        return Arrays.stream(values())
                .filter(value -> value.label.equals(weatherCondition.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new Exception("Value out of -100 .. 100 range."));
    }

    public static WeatherRange get(int val) throws Exception {
        return Arrays.stream(values())
                .filter(r -> val >= r.min && val <= r.max)
                .findFirst()
                .orElseThrow(() -> new Exception("Value out of -100 .. 100 range."));
    }
}
