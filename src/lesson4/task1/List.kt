@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import kotlinx.html.I
import lesson1.task1.discriminant
<<<<<<< .merge_file_a22648
import lesson3.task1.digitNumber
import lesson6.task1.firstDuplicateIndex
import java.util.*
import kotlin.math.pow
=======
import lesson1.task1.sqr
import lesson3.task1.digitNumber
import lesson3.task1.isPrime
>>>>>>> .merge_file_a22384
import kotlin.math.sqrt
import kotlin.math.pow


// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.lowercase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */

fun abs(v: List<Double>) = sqrt(v.sumOf { it * it })


/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */

fun mean(list: List<Double>) = if (list.isEmpty()) 0.0 else list.average()



/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {

    val x = mean(list)
    for (i in 0 until list.size) {
        list[i] -= x
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */

fun times(a: List<Int>, b: List<Int>): Int {
    var c = 0
    for (i in a.indices)
        c += a[i] * b[i]
    return c

}


/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int {

    var k = 0
    val y = x.toDouble()
    return p.sumOf { it * y.pow(k++) }.toInt()
}


/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> {

    var previousElement = 0
    for (i in 0 until list.size) {
        list[i] += previousElement
        previousElement = list[i]
    }
    return list
}


/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */

fun factorize(n: Int): List<Int> {
    var num = n
    val list = mutableListOf<Int>()
    for (i in 2 until num + 1) {
        while (num % i == 0) {
            num /= i
            list.add(i)
        }
    }
    return list

}

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")


/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {

    var n = n
    val list = mutableListOf<Int>()
    do {
        list.add(n % base)
        n /= base
    } while (n > 0)
    return list.reversed()

}

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */

fun convertToString(n: Int, base: Int): String =
    convert(n, base).joinToString(separator = "") {
        if (it >= 10) (it + 'a'.toInt() - 10).toChar().toString() else it.toString()
    }


/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {

    var n = 0.0
    var basepow = 1
    val dig = digits.reversed()
    for (i in digits.indices) {
        n += dig[i] * basepow
        basepow *= base
    }
    return n.toInt()

}

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int {
    val mas: MutableList<Int> = mutableListOf()
    str.forEach {
        mas.add(
            when (it) {
                in '0'..'9' -> it - '0'
                else -> it - 'a' + 10
            }
        )
    }
    return decimal(mas, base)
}

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */

fun roman(n: Int): String {
    val listOfLetters = listOf<String>(
        "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
        "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",
        "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",
        "M"
    )
    val listOfNumbers = listOf<Int>(
        1, 2, 3, 4, 5, 6, 7, 8, 9,
        10, 20, 30, 40, 50, 60, 70, 80, 90,
        100, 200, 300, 400, 500, 600, 700, 800, 900,
        1000
    )

    var number = n
    val amount = n.toString().length
    var string = ""
    var pow = 10.0.pow(amount).toInt()
    for (i in amount downTo 0) {
        var firstNum = (number / pow) * pow
        number %= pow
        pow /= 10
        while (firstNum > 1000) {
            string += "M"
            firstNum -= 1000
        }
        if (firstNum > 0) {
            string += listOfLetters[listOfNumbers.indexOf(firstNum)]
        }
    }
    return string
}


/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */

fun un(n: Int) = when (n) {
    1 -> "один"
    2 -> "два"
    3 -> "три"
    4 -> "четыре"
    5 -> "пять"
    6 -> "шесть"
    7 -> "семь"
    8 -> "восемь"
    9 -> "девять"
    else -> ""
}


fun un2(n: Int) = when (n) {
    1 -> "одна тысяча"
    2 -> "две тысячи"
    3 -> "три тысячи"
    4 -> "четыре тысячи"
    5 -> "пять тысяч"
    6 -> "шесть тысяч"
    7 -> "семь тысяч"
    8 -> "восемь тысяч"
    9 -> "девять тысяч"
    else -> ""
}


fun hot(n: Int, m: Int): String { // если нам нужная фун-ия для сотен(m == any), для тысяч(m == 1)
    val mas = mutableListOf<Int>()
    var k = digitNumber(n)
    val ch = n.toString()
    for (i in 0 until k) {
        mas += ch[i].digitToInt()
    }
    val otv = StringBuilder()
    var flag = 0
    for (i in 0 until digitNumber(n)) {
        when (k) {
            3 -> if (mas[i] == 0) break
            else {
                if (mas[i] == 1) otv.append("сто")
                else if (mas[i] == 2) otv.append("двести")
                else if ((mas[i] > 2) && (mas[i] <= 4)) otv.append((un(mas[i]) + "ста"))
                else otv.append(un(mas[i]) + "сот")
            }
            2 -> if (mas[i] != 0) {
                if (mas[i] == 1) {
                    when (mas[i + 1]) {
                        0 -> otv.append("десять")
                        1 -> otv.append("одиннадцать")
                        2 -> otv.append("двенадцать")
                        3 -> otv.append("тринадцать")
                        4 -> otv.append("четырнадцать")
                        5 -> otv.append("пятнадцать")
                        6 -> otv.append("шестнадцать")
                        7 -> otv.append("семнадцать")
                        8 -> otv.append("восемнадцать")
                        9 -> otv.append("девятнадцать")
                    }
                    if (m == 1) otv.append(" " + "тысяч" + " ")
                    else otv.append(" ")
                    break
                } else {
                    if ((mas[i] >= 2) && (mas[i] <= 3)) otv.append(un(mas[i]) + "дцать")
                    else if (mas[i] == 4) otv.append("сорок")
                    else if (mas[i] == 9) otv.append("девяносто")
                    else otv.append(un(mas[i]) + "десят")
                }
            } else flag = 1
            1 -> {
                if (m == 1) {
                    if (mas[i] == 0) otv.append("тысяч")
                    else otv.append(un2(mas[i]))
                } else {
                    if (mas[i] == 0) break
                    else otv.append(un(mas[i]))
                }
            }
        }
        if (flag == 0) otv.append(" ")
        else flag = 0
        k--
    }
    return if (m == 1) otv.toString()
    else otv.toString().dropLast(1)
}

fun russian(n: Int): String {
    if (n == 0) return "ноль"
    val x = n % 1000
    val y = n / 1000
    return if (y > 0) {
        if (x > 0) hot(y, 1) + hot(x, 0)
        else (hot(y, 1) + hot(x, 0)).dropLast(1)
    } else hot(x, 0)
}


