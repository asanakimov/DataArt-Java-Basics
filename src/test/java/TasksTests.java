import com.dataart.itschool.OptionalTasksSolution;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.dataart.itschool.MainTasksSolutions.*;
import static com.dataart.itschool.OptionalTasksSolution.*;
import static com.dataart.itschool.Utils.*;

public class TasksTests {

  public static final int NUMBER_OF_COLUMNS = 20;
  public static final int[] EXPECTED_PRIMES_ARRAY =
      new int[] {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
        97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181,
        191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
        283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397,
        401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503,
        509, 521, 523, 541
      };
  private static final int[] UNSORTED_ARRAY = new int[] {55, 42, 16, 877, 24, 62, 56};
  private static final int[] SORTED_ARRAY = new int[] {16, 24, 42, 55, 56, 62, 877};

  /*
   * Task 0. Написать метод который конвертирует цифровое значение в строку.
   */
  @Test
  public void task0Test() {
    int integerValue = 454;
    String expectedValue = "454";
    String actualValue = convertNumberToString(integerValue);
    println("[ Task 0 Test ]");
    printResult(expectedValue, actualValue);
    Assert.assertEquals(expectedValue, actualValue);
  }

  /*
   * Task 1. Написать метод, который принимает целое число, и возвращает его сумму цифр.
   */
  @Test
  public void task1Test() {
    int integerValue = 1985;
    String expectedValue = "23";
    String actualValue = returnSumOfDigits(integerValue);
    println("[ Task 1 Test ]");
    printResult(expectedValue, actualValue);
    Assert.assertEquals(expectedValue, actualValue);
  }

  /*
   * Task 2. Написать метод, который принимает пустой массив из 100 элементов,
   *         и заполняет его первыми 100 простыми числами.
   */
  @Test
  public void task2Test() {
    println("[ Task 2 Test ]");
    println("[ expected Result Array ]");
    printArrayAsTable(EXPECTED_PRIMES_ARRAY, NUMBER_OF_COLUMNS);

    int[] actualResultArray = new int[100];
    fillWithPrimeNumbers(actualResultArray);
    println("[ actual Result Array ]");
    printArrayAsTable(actualResultArray, NUMBER_OF_COLUMNS);

    printResult(EXPECTED_PRIMES_ARRAY, actualResultArray);
    Assert.assertEquals(EXPECTED_PRIMES_ARRAY, actualResultArray);
  }

  /*
   * Task 2.1 Добавить метод принимающий произвольный размер массива,
   *          создающий его и переиспользующий task2 для решения
   */
  @Test
  public void task21Test() {

    println("[ Task 2.1 Test ]");
    println("[ expected Result Array ]");
    printArrayAsTable(EXPECTED_PRIMES_ARRAY, NUMBER_OF_COLUMNS);

    int[] actualResultArray = generatePrimeNumbersArray(100);
    println("[ actual Result Array ]");
    printArrayAsTable(actualResultArray, NUMBER_OF_COLUMNS);

    printResult(EXPECTED_PRIMES_ARRAY, actualResultArray);
    Assert.assertEquals(EXPECTED_PRIMES_ARRAY, actualResultArray);
  }

  /*
   * Task 3. Написать метод, который принимает массив целых чисел произвольного размера,
   *         и возвращает среднее арифметическое этих чисел
   */
  @Test
  public void task3Test() {
    int[] inputArray = {12, 22, 32, 42, 52, 62};
    double expectedValue = 37.0d;
    double actualValue = arithmeticMeanOf(inputArray);
    println("[ Task 3 Test ]");
    printResult(expectedValue, actualValue);
    Assert.assertEquals(expectedValue, actualValue);
  }

  /*
   * Task 3.1 Написать метод, который принимает массив целых чисел произвольного размера,
   *          и возвращает среднее геометрическое этих чисел
   */
  @Test
  public void task31Test() {
    int[] inputArray = {5, 5, 5};
    double expectedValue = 5.0d;
    double actualValue = geometricMeanOf(inputArray);
    // result is 4.9999999999 which is not equal to 5
    double roundedActualValue = roundDecimalUsingPowers(actualValue, 2);
    println("[ Task 3.1 Test ]");
    printResult(expectedValue, roundedActualValue);
    Assert.assertEquals(expectedValue, roundedActualValue);
  }

  /*
   * Task 4. Написать метод, который принимает массив целых чисел произвольной длины,
   *         и возвращает отсортированный по возрастанию. Выбрать реализацию одного/
   *         нескольких/или всех опциональных методов сортировки
   */
  // bubble sort
  @Test
  public void task4Test() {

    println("[ Task 4 Test : bubble sort]");
    println("[ expected Result Array ]");
    printArrayAsTable(SORTED_ARRAY, 20);

    println("[ actual Result Array ]");
    bubbleSort(UNSORTED_ARRAY);
    printArrayAsTable(UNSORTED_ARRAY, 20);

    printResult(SORTED_ARRAY, UNSORTED_ARRAY);
    Assert.assertEquals(SORTED_ARRAY, UNSORTED_ARRAY);
  }

  // quick sort
  @Test
  public void task41Test() {

    println("[ Task 4.1 Test : quick sort ]");
    println("[ expected Result Array ]");
    printArrayAsTable(SORTED_ARRAY, 20);

    println("[ actual Result Array ]");
    quickSort(UNSORTED_ARRAY);
    printArrayAsTable(UNSORTED_ARRAY, 20);

    printResult(SORTED_ARRAY, UNSORTED_ARRAY);
  }

  // radix sort
  @Test
  public void task42Test() {

    println("[ Task 4.1 Test : radix sort ]");
    println("[ expected Result Array ]");
    printArrayAsTable(SORTED_ARRAY, 20);

    println("[ actual Result Array ]");
    radixSort(UNSORTED_ARRAY);
    printArrayAsTable(UNSORTED_ARRAY, 20);

    printResult(SORTED_ARRAY, UNSORTED_ARRAY);
  }

  /*
   * Task 5. Написать метод, который принимает 2 строки: подстроку и основную строку.
   *         Возвращает количество включений подстроки в основную строку
   *         (игнорируя кейс, т.е. большая и маленькая буква считаются одной и той же).
   */
  @Test
  public void task5Test() {
    String inputSentence =
        "Java School allows you to try java programming language "
            + "on practice. Java is one of the most popular programming languages. I love "
            + "Java!!!";
    String searchWord = "Java";

    int expectedValue = 4;
    int actualValue = countWordsInSentence(searchWord, inputSentence);

    println(("[ Task 5 Test : count word occurrence in sentence ]"));
    printResult(expectedValue, actualValue);
    Assert.assertEquals(expectedValue, actualValue);
  }

  /*
   * Task 5.1 Добавить метод который будет не просто считать,
   *          а возвращать массив индексов начала каждого из включений
   */
  @Test
  public void task51Test() {
    String inputSentence =
        "Java School allows you to try java programming language "
            + "on practice. Java is one of the most popular programming languages. I love "
            + "Java!!!";
    String searchWord = "Java";

    int[] expectedIndexesArray = {0, 30, 69, 131};
    int[] actualIndexesArray = wordsIndexesInSentence(searchWord, inputSentence);

    println(("[ Task 5.1 Test : return indexes of word occurrence in sentence ]"));
    printResult(Arrays.toString(expectedIndexesArray), Arrays.toString(actualIndexesArray));
  }

  /*
   * Optional Task 1
   * Написать метод-генератор, который будет создавать одномерный массив
   * представляющий конкретный день и его температуру:
   * */
  @Test
  public void optionalTask12Test() throws Exception {

    int[] temperaturesArray = generateRandomMonthTemperatures(29);

    println(("[ Optional Task 1 Test : generate temperatures from -100 to 100 ]"));
    printArrayAsTable(temperaturesArray, 7);

    for (int day = 1, i = 0; i < temperaturesArray.length; day++, i++) {
      println(
          day
              + " день, "
              + temperaturesArray[i]
              + " градусов - "
              + Arrays.toString(getProperClothing(temperaturesArray[i])));
    }
  }

  @Test
  public void optionalTask3Test() throws Exception {
    int days = 3;
    println(("[ Optional Task 1.3 Test ] : generate temperatures for " + days + " days."));
    getWeatherForecast(days);
  }

  @Test
  public void optionalTask21Test() throws Exception {
    String weatherCondition = "Жарко";
    println(
        ("[ Optional Task 2.1 Test ] : generate temperatures for " + weatherCondition + " days."));
    println(Arrays.toString(OptionalTasksSolution.getProperClothing(weatherCondition)));
  }
}
