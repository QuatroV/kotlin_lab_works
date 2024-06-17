import kotlin.math.*
import java.lang.Exception

class Vector(private val elements: MutableList<Double>) {
    // Размерность вектора
    private val size: Int
        get() = elements.size

    // Индексация
    operator fun get(index: Int): Double {
        require(index in 0..<size) { "Индекс вне диапазона: $index" }
        return elements[index]
    }

    // Индексация для изменения
    operator fun set(index: Int, value: Double) {
        require(index in 0..<size) { "Индекс вне диапазона: $index" }
        elements[index] = value
    }

    // Сложение векторов
    operator fun plus(other: Vector): Vector {
        require(size == other.size) { "Размер векторов должен быть одинаковый" }
        return Vector((elements.indices).map { i -> elements[i] + other[i] }.toMutableList())
    }

    // Вычитание векторов
    operator fun minus(other: Vector): Vector {
        require(size == other.size) { "Размер векторов должен быть одинаковый" }
        return Vector((elements.indices).map { i -> elements[i] - other[i] }.toMutableList())
    }

    // Умножение вектора на скаляр
    operator fun times(scalar: Double): Vector {
        return Vector(elements.map { it * scalar }.toMutableList())
    }

    // Инкремент
    operator fun inc(): Vector {
        return this + Vector(MutableList(size) { 1.0 })
    }

    // Декремент
    operator fun dec(): Vector {
        return this - Vector(MutableList(size) { 1.0 })
    }

    // Скалярное произведение
    fun dot(other: Vector): Double {
        require(size == other.size) { "Размер векторов должен быть одинаковый" }
        return elements.indices.sumOf { i -> elements[i] * other[i] }
    }

    // Длина вектора
    private fun magnitude(): Double {
        return sqrt(elements.sumOf { it * it })
    }

    // Угол между векторами в градусах
    fun angleWith(other: Vector): Double {
        val dotProduct = this.dot(other)
        val magnitudes = this.magnitude() * other.magnitude()
        require(magnitudes != 0.0) { "Длина векторов не должна быть нулевой" }
        return acos(dotProduct / magnitudes) * (180 / PI)
    }
}

fun main() {
    try {
        val vectors = arrayOf(
            Vector(mutableListOf(1.0, 2.0, 3.0)),
            Vector(mutableListOf(4.0, 5.0, 6.0)),
            Vector(mutableListOf(0.0, 0.0, 0.0))
        )

        for (i in vectors.indices) {
            for (j in i + 1..<vectors.size) {
                val v1 = vectors[i]
                val v2 = vectors[j]
                println("Угол между вектором ${i+1} и вектором ${j+1} - ${v1.angleWith(v2)} градусов")
            }
        }
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    } catch (e: ArithmeticException) {
        println("Ошибка в математических вычислениях: ${e.message}")
    } catch (e: OutOfMemoryError) {
        println("Ошибка: Недостаточно памяти")
    } catch (e: Exception) {
        println("Произошла ошибка: ${e.message}")
    }
}
