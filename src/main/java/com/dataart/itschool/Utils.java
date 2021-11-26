package com.dataart.itschool;

import java.util.Arrays;

public class Utils {

  static final String FORMAT_TABLE = "| %1$-40s | %2$-40s | %3$-7s |\n";

  public static void printResult(Object expectedResultText, Object actualResultText) {
    System.out.format(
        FORMAT_TABLE,
        "Expected result: " + expectedResultText,
        "Actual result: " + actualResultText,
        " " + expectedResultText.equals(actualResultText));
    println("");
  }

  public static void printResult(int[] expectedResultArray, int[] actualResultArray) {
    System.out.format(
        FORMAT_TABLE,
        "Expected result: [ expectedResultArray ]",
        "Actual result: [ actualResultArray ]",
        " " + Arrays.equals(expectedResultArray, actualResultArray));
    println("");
  }

  public static void println(String text) {
    System.out.println(text);
  }

  public static void print(String text) {
    System.out.print(text);
  }

  public static void printArrayAsTable(int[] array, int numberOfColumns) {
    for (int i = 0; i < array.length; i++) {
      System.out.format("%1$4s", convert(array[i]));
      if ((i > 0) && ((i + 1) % numberOfColumns == 0)) {
        System.out.println();
      }
    }
    println("");
  }

  public static double roundDecimalUsingPowers(double decimalValue, int decimalPlace) {
    return ((long)
            ((decimalValue * Math.pow(10.0, decimalPlace)) + ((decimalValue < 0.0) ? -0.5 : 0.5)))
        / Math.pow(10.0, decimalPlace);
  }

  static String convert(int input) {
    return String.valueOf(input);
  }
}
