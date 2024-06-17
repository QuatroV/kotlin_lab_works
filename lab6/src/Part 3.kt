import kotlin.math.abs

class NumberStorage {
    private val numbers: MutableList<Int> = mutableListOf()

    // Добавление числа
    fun add(number: Int) {
        numbers.add(number)
    }

    // Удаление числа
    fun remove(number: Int) {
        numbers.remove(number)
    }

    // Поиск числа, наиболее близкого к заданному
    fun findClosest(number: Int): Int? {
        if (numbers.isEmpty()) return null

        var closest = numbers[0]
        var minDifference = abs(number - closest)

        for (num in numbers) {
            val difference = abs(number - num)
            if (difference < minDifference) {
                closest = num
                minDifference = difference
            }
        }

        return closest
    }
}

fun main() {
    val storage = NumberStorage()

    storage.add(10)
    storage.add(20)
    storage.add(30)
    storage.add(40)

    println("Наиболее близкое число к 24: ${storage.findClosest(24)}")
    println("Наиболее близкое число к 32: ${storage.findClosest(32)}")
    println("Наиболее близкое число к 3: ${storage.findClosest(3)}")

    storage.remove(20)
    println("Наиболее близкое число к 24 после удаления 20: ${storage.findClosest(24)}")
}
