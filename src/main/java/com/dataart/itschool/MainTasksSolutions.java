package com.dataart.itschool;

import java.util.Locale;
import java.util.Scanner;

import static com.dataart.itschool.Utils.print;
import static com.dataart.itschool.Utils.printResult;
import static com.dataart.itschool.Utils.println;


public class MainTasksSolutions {

  public static final int DECIMAL_PLACE = 2;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    /*
     * Task 3.2 Добавить возможность возможность ввода цифр с клавиатуры
     *          с использованием Scanner(System.in))
     *          и возвращает среднее арифметическое/геометрическое этих чисел
     */
    print("Please, enter size of array: ");
    int arraySize = scanner.nextInt();
    int[] inputArray = new int[arraySize];
    println("Please, enter number values separated by ENTER: ");
    for (int i = 0; i < arraySize; i++) {
      inputArray[i] = scanner.nextInt();
    }
    // assume you input [arraySize] times number 5
    double expectedValue = 5.0d;
    double actualValue = geometricMeanOf(inputArray);
    // result is 4.9999999999 which is not equal to 5
    double roundedActualValue = Utils.roundDecimalUsingPowers(actualValue, DECIMAL_PLACE);
    println("[ Task 3.2 Test ]");
    printResult(expectedValue, roundedActualValue);
  }

  /** решения заданий */

  // Task 0. Написать метод который конвертирует цифровое значение в строку.
  public static String convertNumberToString(int input) {
    return Utils.convert(input);
  }

  // Task 1. Написать метод, который принимает целое число, и возвращает его сумму цифр.
  public static String returnSumOfDigits(int input) {
    String numberValue = convertNumberToString(input);
    int sum = 0;
    for (String s : numberValue.split("")) {
      sum += Integer.parseInt(s);
    }
    return convertNumberToString(sum);
  }

  // Task 2 Написать метод, который принимает пустой массив из 100 элементов,
  //        и заполняет его первыми 100 простыми числами.
  public static void fillWithPrimeNumbers(int[] array) {
    if (array.length > 0) {
      array[0] = 2; // first prime number
      int index = 0;
      int n = 3; // second prime number
      while (index < array.length - 1) {
        boolean isPrime = true;
        // check if number isPrime by looking for prime divisors
        for (int i = 0; i <= index; i++) {
          if (n % array[i] == 0) {
            isPrime = false;
            break;
          }
        }
        if (isPrime) {
          index++;
          array[index] = n;
        }
        n += 2; // after 2 there are no even prime numbers, only odd numbers are checked
      }
    } else {
      println("Array length has to be greater than 0");
    }
  }

  // Task 2.1 Добавить метод принимающий произвольный размер массива,
  // создающий его и переиспользующий task2 для решения
  public static int[] generatePrimeNumbersArray(int arraySize) {
    int[] primeNumbers = new int[arraySize];
    fillWithPrimeNumbers(primeNumbers);
    return primeNumbers;
  }

  // Task 3. Написать метод, который принимает массив целых чисел произвольного размера,
  //        и возвращает среднее арифметическое этих чисел
  public static double arithmeticMeanOf(int[] array) {
    double sum = 0;
    for (int number : array) {
      sum += number;
    }
    return sum / (array.length);
  }

  // Task 3.1 Написать метод, который принимает массив целых чисел произвольного размера,
  //        и возвращает среднее геометрическое этих чисел

  public static double geometricMeanOf(int[] array) {
    int n = array.length;
    double logarithmsSum = 0.0d;
    for (int j : array) {
      if (j == 0L) {
        return 0.0d;
      }
      logarithmsSum += Math.log(j);
    }
    return Math.exp(logarithmsSum / n);
  }

  /*
   * Task 4. Написать метод, который принимает массив целых чисел произвольной длины,
   *         и возвращает отсортированный по возрастанию. Выбрать реализацию одного/
   *         нескольких/или всех опциональных методов сортировки
   */
  public static void bubbleSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      boolean isSorted = true;
      for (int j = 0; j < array.length - 1; j++) {
        if (array[j] > array[j + 1]) {
          swap(array, j, j + 1);
          isSorted = false;
        }
      }
      if (isSorted) {
        return;
      }
    }
  }

  public static void quickSort(int[] array) {
    sort(array, 0, array.length - 1);
  }

  private static void sort(int[] array, int low, int high) {
    if (low < high) {
      // pi is partitioning index, array[p]
      // is now at right place
      int pi = partition(array, low, high);

      // Separately sort elements before
      // partition and after partition
      sort(array, low, pi - 1);
      sort(array, pi + 1, high);
    }
  }

  private static int partition(int[] array, int low, int high) {
    // pivot
    int pivot = array[high];

    // Index of smaller element and indicates the right position
    // of pivot found so far
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {

      // If current element is smaller than the pivot
      if (array[j] < pivot) {

        // Increment index of smaller element
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, high);
    return (i + 1);
  }

  private static void swap(int[] array, int i, int j) {
    int t = array[i];
    array[i] = array[j];
    array[j] = t;
  }

  public static void radixSort(int[] array) {
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (max < array[i]) {
        max = array[i];
      }
    }

    for (int s = 1; max / s > 0; s *= 10) {
      countingSortForRadix(array, s);
    }
  }

  private static void countingSortForRadix(int[] array, int s) {

    int[] digitsFrequencyArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // count frequencies of all digits in given decimal place s
    for (int j : array) {
      digitsFrequencyArray[(j / s) % 10]++;
    }

    // sum all the frequencies to previous ones consequently
    for (int i = 1; i < 10; i++) {
      digitsFrequencyArray[i] += digitsFrequencyArray[i - 1];
    }

    // place all the numbers according to digit place into new outputArray
    int[] outputArray = {0, 0, 0, 0, 0, 0, 0, 0};
    for (int i = array.length - 1; i >= 0; i--) {
      outputArray[--digitsFrequencyArray[(array[i] / s) % 10]] = array[i];
    }
    // copy outputArray to array
    System.arraycopy(outputArray, 0, array, 0, array.length);
  }

  /*
   * Task 5. Написать метод, который принимает 2 строки: подстроку и основную строку.
   *         Возвращает количество включений подстроки в основную строку
   *         (игнорируя кейс, т.е. большая и маленькая буква считаются одной и той же).
   */

  public static int countWordsInSentence(String searchWord, String inputSentence) {
    if (searchWord.isEmpty() || inputSentence.isEmpty()) {
      return 0;
    }
    int index = 0;
    int count = 0;
    while (true) {
      index = getNextIndex(searchWord, inputSentence, index);
      if (index != -1) {
        count++;
        index += searchWord.length();
      } else {
        break;
      }
    }
    return count;
  }

  private static int getNextIndex(String searchWord, String inputSentence, int index) {
    index =
        inputSentence.toLowerCase(Locale.ROOT).indexOf(searchWord.toLowerCase(Locale.ROOT), index);
    return index;
  }

  /*
   * Task 5.1 Добавить метод который будет не просто считать,
   *          а возвращать массив индексов начала каждого из включений
   */
  public static int[] wordsIndexesInSentence(String searchWord, String inputSentence) {

    int arraySize = countWordsInSentence(searchWord, inputSentence);
    int[] arrayOfIndexes = new int[arraySize];

    if (searchWord.isEmpty() || inputSentence.isEmpty()) {
      return null;
    }

    int index = 0;
    int count = 0;

    while (true) {
      index = getNextIndex(searchWord, inputSentence, index);
      if (index != -1) {
        arrayOfIndexes[count] = index;
        index += searchWord.length();
        count++;
      } else {
        break;
      }
    }
    return arrayOfIndexes;
  }
}
