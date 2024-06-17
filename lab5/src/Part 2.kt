import kotlin.math.*

class VectorSizeMismatchException(message: String) : Exception(message)
class ZeroMagnitudeException(message: String) : Exception(message)
class InvalidIndexException(message: String) : Exception(message)

class Vector2(private val elements: MutableList<Double>) {
    // Размерность вектора
    private val size: Int
        get() = elements.size

    // Индексация
    operator fun get(index: Int): Double {
        if (index !in 0..<size) throw InvalidIndexException("Индекс вне диапазона: $index")
        return elements[index]
    }

    // Индексация для изменения
    operator fun set(index: Int, value: Double) {
        if (index !in 0..<size) throw InvalidIndexException("Индекс вне диапазона: $index")
        elements[index] = value
    }

    // Конструктор, принимающий размерность вектора и инициализирующий нулями
    constructor(size: Int) : this(MutableList(size) { 0.0 })

    // Конструктор, принимающий массив значений
    constructor(elements: Array<Double>) : this(elements.toMutableList())

    // Сложение векторов
    operator fun plus(other: Vector2): Vector2 {
        if (size != other.size) throw VectorSizeMismatchException("Размер векторов должен быть одинаковый")
        return Vector2((elements.indices).map { i -> elements[i] + other[i] }.toMutableList())
    }

    // Вычитание векторов
    operator fun minus(other: Vector2): Vector2 {
        if (size != other.size) throw VectorSizeMismatchException("Размер векторов должен быть одинаковый")
        return Vector2((elements.indices).map { i -> elements[i] - other[i] }.toMutableList())
    }

    // Умножение вектора на скаляр
    operator fun times(scalar: Double): Vector2 {
        return Vector2(elements.map { it * scalar }.toMutableList())
    }

    // Скалярное произведение
    fun dot(other: Vector2): Double {
        if (size != other.size) throw VectorSizeMismatchException("Размер векторов должен быть одинаковый")
        return elements.indices.sumOf { i -> elements[i] * other[i] }
    }

    // Модуль вектора (длина)
    fun magnitude(): Double {
        return sqrt(elements.sumOf { it * it })
    }

    // Проверка отношений между векторами
    fun checkRelationship(other: Vector2): String {
        if (this.dot(other) == 0.0) {
            return "Ортогональные"
        } else {
            var ratio: Double? = null
            for (i in elements.indices) {
                if (elements[i] != 0.0) {
                    if (other.elements[i] == 0.0) {
                        return "Не ортогональны и не коллинеарны"
                    }
                    val currentRatio = other.elements[i] / elements[i]
                    if (ratio == null) {
                        ratio = currentRatio
                    } else if (ratio != currentRatio) {
                        return "Не ортогональны и не коллинеарны"
                    }
                } else if (other.elements[i] != 0.0) {
                    return "Не ортогональны и не коллинеарны"
                }
            }
            return "Коллинеарны"
        }
    }
}

fun main() {
    try {
        val vectors = arrayOf(
            Vector2(arrayOf(1.0, 2.0, 3.0)),
            Vector2(arrayOf(2.0, 4.0, 6.0, 3.2)), // Коллинеарный с Vector 1
            Vector2(arrayOf(0.0, 3.0, -1.0)),
            Vector2(arrayOf(1.0, 1.0, -1.0)) // Ортогонален к v1
        )

        // Проверка пар векторов
        for (i in vectors.indices) {
            for (j in i + 1..<vectors.size) {
                println("Отношение между вектором ${i + 1} и вектором ${j + 1}: ${vectors[i].checkRelationship(vectors[j])}")
            }
        }
    } catch (e: VectorSizeMismatchException) {
        println("Ошибка: ${e.message}")
    } catch (e: ZeroMagnitudeException) {
        println("Ошибка: ${e.message}")
    } catch (e: InvalidIndexException) {
        println("Ошибка: ${e.message}")
    } catch (e: Exception) {
        println("Произошла ошибка: ${e.message}")
    }
}
