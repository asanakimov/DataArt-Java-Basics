**Требования:**

Все задания должны быть выполнены отдельными методами (task1/task2/task2\_1/...) в Главном классе, принимать аргументы и возвращать значение - из условия.

Каждое дополнительное задание реализовать в отдельном методе, и при возможности переиспользовать метод основного задания.

В главном методе для каждой задачи поочередно:

- Отдельно объявить переменными все входящие аргументы, и ожидаемые результаты.
- Вызвать task1/task2/..., сохранить значение в новую переменную.
- По каждому заданию вывести переменные в консоль

Или опционально:

- Вывести на экран в формате таблицы (StringBuilder и Format может будет вам полезен), приведенными к строкам : ожидаемый результат, действительный результат, и true/false для их совпадения.

`   `[https://stackoverflow.com/questions/2745206/output-in-a-table-format-in-javas-system-out#answer-46055572

]( l )

**Пример:**

Task 0. Написать метод который конвертирует цифровое значение в строку.

public static void main(String[] args) {
`    `int input = 454;
`    `String task0Result = *task0*(input);
`    `System.*out*.println("Result of task 0: " + task0Result);
}

public static String task0(int input) {
`    `return String.*valueOf*(input);
}

[

](https://stackoverflow.com/questions/2745206/output-in-a-table-format-in-javas-system-out#answer-46055572)

**Обязательные задания:**

Task 1. Написать метод, который принимает целое число, и возвращает его сумму цифр.

Например: task1(1985) = 1+9+8+5=23

Task 2. Написать метод, который принимает пустой массив из 100 элементов, и заполняет его первыми 100 простыми числами.

Например task2(new int[100])= {2, 3, 5, 7, 11, 13, ..., 541}

2.1 **(Опционально)** Добавить метод принимающий произвольный размер массива, создающий его и переиспользующий task2 для решения

<https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D1%81%D1%82%D0%BE%D0%B5_%D1%87%D0%B8%D1%81%D0%BB%D0%BE>
<https://www.baeldung.com/java-generate-prime-numbers>

Task 3. Написать метод, который принимает массив целых чисел произвольного размера, и возвращает среднее арифметическое этих чисел (учтите, что оно может быть нецелым).

Например task3({12, 22, 32, 42, 52, 62}) =(12+22+32+42+52+62)/6=37.0

[https://ru.wikipedia.org/wiki/%D0%A1%D1%80%D0%B5%D0%B4%D0%BD%D0%B5%D0%B5_%D0%B0%D1%80%D0%B8%D1%84%D0%BC%D0%B5%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%BE%D0%B5]( )

3.1**(Опционально)** Добавить метод расчитывающий среднее геометрическое

<https://ru.wikipedia.org/wiki/%D0%A1%D1%80%D0%B5%D0%B4%D0%BD%D0%B5%D0%B5_%D0%B3%D0%B5%D0%BE%D0%BC%D0%B5%D1%82%D1%80%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%BE%D0%B5>

3.2 **(Опционально)** Добавить возможность возможность ввода цифр с клавиатуры с использованием Scanner(System.in))

Task 4. Написать метод, который принимает массив произвольной длины целых чисел, и возвращает отсортированный по возрастанию. Выбрать реализацию одного/нескольких/или всех опциональных методов сортировки.

Например task4({55, 42, 16, 877, 24, 62, 56})={16, 24, 42, 55, 56, 62, 877}

Методы сортировки:

- Сортировка пузырьком: Самая простая. Использовать не более 1 промежуточной переменной. Использовать двойной цикл для реализации. В двойном цикле сравниваются различные (a[i] > a[j]) элементы массива, и меняются местами в случае если они не упорядоченны по возрастанию относительно своих индексов.

[https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D1%83%D0%B7%D1%8B%D1%80%D1%8C%D0%BA%D0%BE%D0%BC]()

- Богосорт: Самая безсмысленная. Использовать рекурсию для реализации. Алгоритм перемешивает случайным образом элементы массива, и проверяет находится ли они в отсортированном виде, если нет - продолжает рекурсию. Аккуратно, ограничтесь малыми массивами так как время выполнения Факториально сложно.

<https://ru.wikipedia.org/wiki/Bogosort>

- Быстрая сортировка: одна из наиболее эффективных для дискретных конечных автоматов (компьютеры на транзисторах и не только, противоположно есть квантовые алгоритмы сортировки для квантовых компьютеров, они еще эффективней). Использовать рекурсию для реализации. Алгоритм делет входящий массив пополам, и вызывается рекурентно на своих половинах. При достижении нижнего уровня рекурсии, алгоритм сравнивает 2 числа (на этот момент это массивы единичной длины), и меняет их местами на уровне выше, таким образом получается отсортированный массив из 2 чисел.

<https://ru.wikipedia.org/wiki/%D0%91%D1%8B%D1%81%D1%82%D1%80%D0%B0%D1%8F_%D1%81%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0>

Если вам интересно какие еще бывают алгоритмы сортировки, можете ознакомиться тут
[https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D1%81%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B8]( )

Task 5. Написать метод, который принимает 2 строки: подстроку и основную строку. Возвращает количество включений подстроки в основную строку (игнорируя кейс, т.е. большая и маленькая буква считаются одной и той же).

Например task5("Java", "Java School allows you to try java programming language on practice. Java one of the most popular programming languages. I love Java!!!") = 4

5.1 Добавить метод который будет не просто считать, а возвращать массив индексов начала каждого из включений

Например task5\_1("Java", "Java School allows you to try java programming language on practice. Java one of the most popular programming languages. I love Java!!!") = {0, 30, 69, 128}

5.2 **(Опционально)** реализовать возможность ввода 2х строк с клавиатуры с использованием Scanner(System.in)


**Опционально:**

Написать метод, который будет генерировать произвольный прогноз погоды выводить его и рекомендации о том как одеться, в зависимости от прогноза

Требования:

Optional task 1. Написать метод-генератор, который будет создавать одномерный массив представляющий конкретный день и его температуру:

- Индекс массива будет являться датой (int[] = new int[29])
- Элемент массива должен содержать int значения: температуру int temp from -100 to +100.
- Данные должны наполняться случайными числами

Например

optionalTask1()

{-8, -5, -3, 2, 3, ...}

1 день, -8 градусов;

2 день, -5 градусов;

...


Optional task 2. Создать ENUM, представляющий собой перечисление типов погоды (Мороз, Прохладно, Тепло, Жарко) и метод принимающий массив температур и возвращающий ENUM с ним ассоциированный (switch-case вам поможет) :

Нужно будет учесть максимальные и минимальные значения температуры, для разделения какой ENUM использовать.

Написать метод который (входные данные на ваше усмотрение) вернет массив из 2 строк для верхней и нижней одежды подходящий для соответствующей погоды

Например optionalTask2(Мороз) = {"Шуба", "Теплые Ботинки"}

**или** optionalTask2(23) = {"Футболка", "Шорты"}


Optional task 3. Создать метод, который будет использовать метод генерации (from optional task 1) и генерировать прогноз на заданное количество дней, проходиться по нему и выводить температуру и рекомендации что взять с собой на основании температуры в каждый из дней.

public static void optionalTask3(2) {
//some realisation
}

Expected console output:

Day 1: -2, Шуба+Теплые Ботинки

Day 2: +40, Футболка+Шорты


