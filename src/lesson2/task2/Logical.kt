@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import java.lang.Integer.max
import java.lang.Integer.min
import kotlin.math.abs
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая (2 балла)
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
<<<<<<< .merge_file_a27468
fun isNumberHappy(number: Int): Boolean =
    (number / 100 % 10) + (number / 1000 % 10) == (number % 10) + (number / 10 % 10)
=======
fun isNumberHappy(number: Int): Boolean {
    val z = number.toString()
    val ch1 = z[0].digitToInt()
    val ch2 = z[1].digitToInt()
    val ch3 = z[2].digitToInt()
    val ch4 = z[3].digitToInt()
    return (ch1 + ch2) == (ch3 + ch4)
}
>>>>>>> .merge_file_a22148

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean =
    ((x1 == x2) || (y1 == y2) || (abs(y2 - y1) == abs(x2 - x1)))


/**
 * Простая (2 балла)
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {

    return when {
        (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) -> 31
        (month == 2 && ((year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0))) -> 29
        (month == 2) -> 28
        else -> 30
    }

}

/**
 * Простая (2 балла)
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    val z = sqrt(sqr(x2 - x1) + sqr(y2 - y1))
    return z + r1 <= r2
}

/**
 * Средняя (3 балла)
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {

    val mas = arrayOf(a, b, c)
    mas.sort()
    return !((mas[0] > min(r, s)) || (mas[1] > max(r, s)))
}

