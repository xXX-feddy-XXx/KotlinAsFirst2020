@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var x = n
    var col = 0
    do {
        col++
        x /= 10
    } while (x > 0)
    return col
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var pred = 1
    var sled = 1
    var box: Int
    var k = 2
    if ((n == 1) || (n == 2)) return 1
    while (k != n) {
        k++
        box = sled
        sled += pred
        pred = box
    }
    return sled
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var d = 2
    while (d * d <= n) {
        if (n % d == 0) return d
        d++
    }
    return if (n == d) d
    else n
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var d = 2
    while (d * d <= n) {
        if (n % d == 0) return n / d
        d++
    }
    return 1
}

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var y = x
    var col = 0
    while (y != 1) {
        col++
        if (y % 2 == 0) y /= 2
        else y = 3 * y + 1
    }
    return col
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var d = 2
    var k: Int
    if (max(n, m) % min(n, m) == 0) return max(n, m)
    while (n * m > d) {
        k = min(n, m) * d
        if ((k % m == 0) && (k % n == 0)) return k
        else d++
    }
    return m * n
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var d = 2
    if (max(m, n) % min(m, n) == 0) return false
    while (d * d <= min(m, n)) {
        if ((min(m, n) % d == 0) && (max(m, n) % d == 0)) return false
        d++
    }
    return true
}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    if (n / 10 == 0) return n
    var k = 0
    var ch1 = n
    var otv = 0
    var d = 1
    while (ch1 > 0) {
        ch1 /= 10
        k += 1
    }
    var p = n
    for (i in 1..k) {
        otv += p / (10.0.pow(k) / 10.0.pow(i)).toInt() * d
        d *= 10
        p %= (10.0.pow(k) / 10.0.pow(i)).toInt()
    }
    return otv
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    if (n / 10 == 0) return true
    var mas = emptyArray<Int>()
    var ch = n
    while (ch > 0) {
        mas += ch % 10
        ch /= 10
    }
    mas.reverse()
    for (i in 0..(mas.size / 2)) {
        if (mas[i] != mas[mas.size - 1 - i]) return false
    }
    return true
}

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    if (n / 10 == 0) return false
    var ch = n
    while (ch > 0) {
        if (ch % 10 != n % 10) return true
        ch /= 10
    }
    return false
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var s = x
    var flag = 0
    var d = 3
    while (kotlin.math.abs(x.pow(d) / factorial(d)) < eps) {
        if (flag == 0) {
            s -= x.pow(d) / factorial(d)
            flag = 1
            d += 2
        } else if (flag == 1) {
            s += x.pow(d) / factorial(d)
            flag = 0
            d += 2
        }
    }
    return s
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun col(n: Int): Int {
    if (n / 10 == 0) return 1
    var s = n
    var k = 0
    while (s > 0) {
        k++
        s /= 10
    }
    return k
}

fun squareSequenceDigit(n: Int): Int {
    var s = 0
    var i = 1.0
    var box = 0
    var ch = 0.0
    while (s < n) {
        s += col(i.pow(2.0).toInt())
        box = col(i.pow(2.0).toInt())
        ch = i.pow(2.0)
        i += 1
    }
    s -= box
    var gl: Int = ch.toInt()
    var mas = emptyArray<Int>()
    while (gl > 0) {
        mas += gl % 10
        gl /= 10
    }
    mas.reverse()
    return (mas[n - s - 1])
}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var s = 0
    var pr = 0
    var box: Int
    var sled = 1
    var dbl = 0
    var cont = 0
    while (s < n) {
        s += col(sled)  // col - функция, которую я написал в предыдущем задании
        dbl = col(sled)
        cont = sled
        box = sled
        sled += pr
        pr = box
    }
    s -= dbl
    var mas = emptyArray<Int>()
    while (cont > 0) {
        mas += cont % 10
        cont /= 10
    }
    mas.reverse()
    return mas[n - s - 1]
}
