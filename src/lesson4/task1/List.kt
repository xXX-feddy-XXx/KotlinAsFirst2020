@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import lesson3.task1.digitNumber
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
fun abs(v: List<Double>): Double {
    if (v.isEmpty()) return 0.0
    var s = 0.0
    for (i in v.indices) {
        s += sqr(v[i])
    }
    return sqrt(s)
}

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    if (list.isEmpty()) return 0.0
    var s = 0.0
    var k = 0
    for (i in list.indices) {
        k++
        s += list[i]
    }
    return (s / k)
}

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    if (list.isEmpty()) return list
    var s = 0.0
    var k = 0
    for (i in list.indices) {
        k++
        s += list[i]
    }
    for (i in list.indices) {
        list[i] -= s / k
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
    if (a.isEmpty() || b.isEmpty()) return 0
    var s = 0
    for (i in a.indices) {
        s += a[i] * b[i]
    }
    return s
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
    if (p.isEmpty()) return 0
    var y = x
    var s = p[0]
    for (i in 1 until p.size) {
        s += p[i] * y
        y *= x // у меня почему-то здесь .pow не работал, пришлось так сделать
    }
    return s
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
    if (list.isEmpty()) return list
    var s = 1
    var box: Int
    for (i in 1 until list.size) {
        box = list[i]
        list[i] += s
        s += box
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
fun pr(n: Int): Boolean {
    var d = 2
    while (d * d <= n) {
        if (n % d == 0) return false
        d++
    }
    return true
}

fun factorize(n: Int): List<Int> {
    if (pr(n)) return listOf(n)
    var mas = emptyList<Int>()
    var d = 2
    var p = n
    while (d <= p) {
        if (p % d == 0) {
            if (pr(d)) mas += d
            p /= d
            d = 2
        }
        d++
    }
    mas.sorted()
    return mas
}

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String {
    if (pr(n)) return "$n"
    var mas = emptyList<Int>()
    var d = 2
    var p = n
    while (d <= p) {
        if (p % d == 0) {
            if (pr(d)) mas += d
            p /= d
            d = 2
        }
        d++
    }
    if (mas.isEmpty()) return "$n"
    mas.sorted()
    return mas.joinToString(separator = "*")
}

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    if (n < base) return listOf(n)
    var mas = emptyList<Int>()
    var ch = n
    while (ch > 0) {
        mas += ch % base
        ch /= base
    }
    return mas.reversed()
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
fun convertToString(n: Int, base: Int): String {
    if ((n < base) && (base <= 10)) return "$n"
    var mas = emptyList<String>()
    var ch = n
    var p: Int
    while (ch > 0) {
        p = ch % base
        mas += if (p >= 10) {
            (p + 55).toChar().toString()
        } else "$p"
        ch /= base
    }
    mas = mas.reversed()
    val otv = mas.joinToString(separator = "")
    return otv.toLowerCase()
}

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var k = digits.size - 1
    var s = 0
    for (i in digits.indices) {
        s += (digits[i] * base.toDouble().pow(k)).toInt()
        k--
    }
    return s
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
    var mas: MutableList<Int> = mutableListOf()
    for (i in str.indices) {
        if (str[i].toChar().toInt() in 97..122) mas.add(
            str[i].toChar().toInt() - 87
        )
        else mas.add(str[i].toString().toInt())
    }
    var k = mas.size - 1
    var s = 0
    for (i in mas.indices) {
        s += (mas[i] * base.toDouble().pow(k)).toInt()
        k--
    }
    return s
}

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun col(n: Int): Int {
    var k = 0
    var x = n
    while (x > 0) {
        k++
        x /= 10
    }
    return k
}

fun ch(n: Int, s: String): String {
    if (n == 0) return ""
    var otv = ""
    for (i in 1..n) {
        otv += s
    }
    return otv
}

fun ed(n: Int): String {
    return if (n <= 3) ch(n, "I")
    else if (n == 4) "I" + "V"
    else if ((n >= 5) && (n <= 8)) "V" + ch(n - 5, "I")
    else "I" + "X"
}

fun des(n: Int): String {
    return if (n <= 3) ch(n, "X")
    else if (n == 4) "XL"
    else if ((n >= 5) && (n <= 8)) "L" + ch(n - 5, "X")
    else "XC"
}

fun sot(n: Int): String {
    return if (n <= 3) ch(n, "C")
    else if (n == 4) "CD"
    else if ((n >= 5) && (n <= 8)) "D" + ch(n - 5, "C")
    else "CM"
}

fun roman(n: Int): String {
    var otv = ""
    var k = col(n)
    return when (k) {
        1 -> ed(n % 10)
        2 -> des(n / 10 % 10) + ed(n % 10)
        3 -> sot(n / 100) + des(n / 10 % 10) + ed(n % 10)
        else -> {
            var p = n
            while (col(p) > 3) {
                p -= 1000
                otv += "M"
            }
            k = col(p)
            return if (p == 0) otv
            else if (k == 1) otv + ed(n % 10)
            else if (k == 2) otv + des(n / 10 % 10) + ed(n % 10)
            else otv + sot(n / 100) + des(n / 10 % 10) + ed(n % 10)
        }
    }
}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun un(n: Int): String {
    when (n) {
        1 -> return "один"
        2 -> return "два"
        3 -> return "три"
        4 -> return "четыре"
        5 -> return "пять"
        6 -> return "шесть"
        7 -> return "семь"
        8 -> return "восемь"
        9 -> return "девять"
    }
    return ""
}

fun un2(n: Int): String {
    when (n) {
        1 -> return "одна тысяча"
        2 -> return "две тысячи"
        3 -> return "три тысячи"
        4 -> return "четыре тысячи"
        5 -> return "пять тысяч"
        6 -> return "шесть тысяч"
        7 -> return "семь тысяч"
        8 -> return "восемь тысяч"
        9 -> return "девять тысяч"
    }
    return ""
}

fun hun(n: Int): String {
    var mas: MutableList<Int> = mutableListOf()
    var k = digitNumber(n)
    val ch = n.toString()
    for (i in 0 until k) {
        mas += ch[i].digitToInt()
    }
    var otv = ""
    var flag = 0
    for (i in 0 until digitNumber(n)) {
        when (k) {
            3 -> if (mas[i] == 0) break
            else {
                otv += if (mas[i] == 1) "сто"
                else if (mas[i] == 2) "двести"
                else if ((mas[i] > 2) && (mas[i] <= 4)) (un(mas[i]) + "ста")
                else un(mas[i]) + "сот"
            }
            2 -> if (mas[i] != 0) {
                if (mas[i] == 1) {
                    when (mas[i + 1]) {
                        0 -> otv += "десять"
                        1 -> otv += "одиннадцать"
                        2 -> otv += "двенадцать"
                        3 -> otv += "тринадцать"
                        4 -> otv += "четырнадцать"
                        5 -> otv += "пятнадцать"
                        6 -> otv += "шестнадцать"
                        7 -> otv += "семнадцать"
                        8 -> otv += "восемнадцать"
                        9 -> otv += "девятнадцать"
                    }
                    otv += " "
                    break
                } else {
                    otv += if ((mas[i] >= 2) && (mas[i] <= 3)) un(mas[i]) + "дцать"
                    else if (mas[i] == 4) "сорок"
                    else if (mas[i] == 9) "девяносто"
                    else un(mas[i]) + "десят"
                }
            } else flag = 1
            1 -> if (mas[i] == 0) break
            else otv += un(mas[i])
        }
        if (flag == 0) otv += " "
        else flag = 0
        k--
    }
    return otv.dropLast(1)
}

fun th(n: Int): String {
    var mas: MutableList<Int> = mutableListOf()
    var k = digitNumber(n)
    val ch = n.toString()
    for (i in 0 until k) {
        mas += ch[i].digitToInt()
    }
    var otv = ""
    var flag = 0
    for (i in 0 until digitNumber(n)) {
        when (k) {
            3 -> if (mas[i] == 0) break
            else {
                otv += if (mas[i] == 1) "сто"
                else if (mas[i] == 2) "двести"
                else if ((mas[i] > 2) && (mas[i] <= 4)) (un(mas[i]) + "ста")
                else un(mas[i]) + "сот"
            }
            2 -> if (mas[i] != 0) {
                if (mas[i] == 1) {
                    when (mas[i + 1]) {
                        0 -> otv += "десять"
                        1 -> otv += "одиннадцать"
                        2 -> otv += "двенадцать"
                        3 -> otv += "тринадцать"
                        4 -> otv += "четырнадцать"
                        5 -> otv += "пятнадцать"
                        6 -> otv += "шестнадцать"
                        7 -> otv += "семнадцать"
                        8 -> otv += "восемнадцать"
                        9 -> otv += "девятнадцать"
                    }
                    otv += " " + "тысяч" + " "
                    break
                } else {
                    otv += if ((mas[i] >= 2) && (mas[i] <= 3)) un(mas[i]) + "дцать"
                    else if (mas[i] == 4) "сорок"
                    else if (mas[i] == 9) "девяносто"
                    else un(mas[i]) + "десят"
                }
            } else flag = 1
            1 -> otv += if (mas[i] == 0) "тысяч"
            else un2(mas[i])
        }
        if (flag == 0) otv += " "
        else flag = 0
        k--
    }
    return otv
}

fun russian(n: Int): String {
    if (n == 0) return "ноль"
    val x = n % 1000
    val y = n / 1000
    return if (y > 0) {
        if (x > 0) th(y) + hun(x)
        else (th(y) + hun(x)).dropLast(1)
    } else hun(x)
}

