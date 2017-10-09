@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import lesson4.task1.abs

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
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
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
    for (m in 2..n/2) {
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
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    if (n == 0) return 1
    var count = 0
    var x = Math.abs(n)
    while (x > 0) {
        x /= 10
        count ++
    }
    return count
}


/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var fibX = 1
    var fibY = 1
    var fibZ = 1
    for (t in 3 .. n){
        fibX = fibY
        fibY = fibX + fibZ
        fibZ = fibX
    }
    return fibY
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var s = 0
    for (i in maxOf(m , n) .. m * n){
        s = i
        if (i % maxOf(m , n) == 0 && i % minOf(m , n) == 0) break
    }
    return s
 }

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var minDiv = 0
    for(i in 2..n){
        minDiv = i
        if(n % i == 0) return i
    }
    return minDiv
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var x = 0
    for(i in n / 2 downTo 1){
        x = i
        if(n % i == 0) return i
    }
    return x
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): () -> Boolean {
    var logicalVariable = 0
    var logicalVariable2 = 1
    for(i in 2..minOf(m , n)){
        if (minOf(m , n) % i == 0) logicalVariable = 2 else logicalVariable = 0
        if (maxOf(m , n) % i == 0) logicalVariable2 = 2 else logicalVariable2 = 1
        if (logicalVariable == logicalVariable2) break
    }
    return{
        (logicalVariable != logicalVariable2)
    }
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    for (i  in 0..n) {
        if ((m <= i * i) && (i * i <= n)) return true
    }
    return false
}
/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var num = n
    var num1 = n
    var count = 0
    var revN = 0
    while(num > 0){
        count += 1
        num /= 10
    }
    while (num1 > 0) {
        count -= 1
        revN = (revN + (num1 % 10) * Math.pow(10.0 , count * 1.0)).toInt()
        num1 /= 10
    }
    return revN
}
/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean { // в процессе
    var num = n
    var num1 = n
    var count = 0
    var noname = 0
    var nlast = 0
    var nfirst = 0
    while(num > 0){
        count += 1
        num /= 10
    }
    if(count == 1) return true
    while(count > 0){
        nfirst = (num / Math.pow(10.0 , count * 1.0)).toInt()
        nlast = num % 10
        num = (num - (num / Math.pow(10.0 , count * 1.0) * Math.pow(10.0, count * 1.0)) / 10).toInt()
        count -= 2
        if(nfirst == nlast) noname = 1 else return false
    }
   return when{
       noname == 1 -> true
       else -> false
   }
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean = TODO()

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int = TODO()

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int = TODO()
