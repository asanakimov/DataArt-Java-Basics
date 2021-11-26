package com.dataart.itschool;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.dataart.itschool.Utils.println;

public class OptionalTasksSolution {

  /*
   * Optional Task 1
   * Написать метод-генератор, который будет создавать одномерный массив
   * представляющий конкретный день и его температуру:
   * */
  private static final Map<WeatherRange, String[]> WEATHER_RANGE_CLOTHING;
  private static final int RANGE_LENGTH = 200;
  private static final int RANGE_LENGTH_MEDIAN = RANGE_LENGTH / 2;

  static {
    WEATHER_RANGE_CLOTHING = new HashMap<>();
    WEATHER_RANGE_CLOTHING.put(WeatherRange.HOT, new String[] {"футболка", "бриджи"});
    WEATHER_RANGE_CLOTHING.put(
        WeatherRange.WARM, new String[] {"рубашка с коротким рукавом", "легкие штаны"});
    WEATHER_RANGE_CLOTHING.put(
        WeatherRange.COOL, new String[] {"рубашка с длинным рукавом или худи", "штаны"});
    WEATHER_RANGE_CLOTHING.put(WeatherRange.COLD, new String[] {"демисезонная куртка", "штаны"});
    WEATHER_RANGE_CLOTHING.put(
        WeatherRange.FREEZING, new String[] {"теплая куртка", "теплые штаны"});
  }

  public static int[] generateRandomMonthTemperatures(int daysNumber) {
    int[] month = new int[daysNumber];

    for (int i = 0; i < daysNumber; i++) {
      month[i] = (int) Math.round(Math.random() * RANGE_LENGTH - RANGE_LENGTH_MEDIAN);
    }
    return month;
  }

  public static String[] getProperClothing(int weatherTemperature) throws Exception {

    WeatherRange weatherRange = WeatherRange.get(weatherTemperature);
    return WEATHER_RANGE_CLOTHING.get(weatherRange);
  }

  public static String[] getProperClothing(String weatherCondition) throws Exception {
    WeatherRange weatherRange = WeatherRange.getByLabel(weatherCondition);
    return WEATHER_RANGE_CLOTHING.get(weatherRange);
  }

  public static void getWeatherForecast(int days) throws Exception {
    int[] temperaturesArray = generateRandomMonthTemperatures(days);
    for (int index = 0; index < days; index++) {
      String[] clothing = getProperClothing(temperaturesArray[index]);
      println(
          (index + 1)
              + " день , "
              + temperaturesArray[index]
              + " градусов - "
              + Arrays.toString(clothing));
    }
  }
}
