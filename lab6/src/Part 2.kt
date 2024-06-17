fun calculateR(iList: List<Double>, uList: List<Double>): Double {
    require(iList.size == uList.size) { "Списки I и U должны быть одинакового размера" }

    val n = iList.size
    if (n == 0) {
        throw IllegalArgumentException("Списки I и U не должны быть пустыми")
    }

    // Вычисляем суммы
    val sumIU = iList.zip(uList).sumOf { it.first * it.second }
    val sumI2 = iList.sumOf { it * it }

    // Вычисляем R по формуле метода наименьших квадратов
    return sumIU / sumI2
}

fun main() {
    val iList = listOf(0.1, 0.2, 0.3, 0.4, 0.5)
    val uList = listOf(1.1, 2.1, 3.1, 4.1, 5.1)

    try {
        val r = calculateR(iList, uList)
        println("Приближенное значение сопротивления R: $r Ом")
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    } catch (e: Exception) {
        println("Произошла ошибка: ${e.message}")
    }
}
