class IntegerSet(private val elements: Set<Int>) {

    // Конструктор для создания множества из списка целых чисел
    constructor(vararg elements: Int) : this(elements.toSet())

    // Метод для объединения множеств
    fun union(other: IntegerSet): IntegerSet {
        val unionSet = this.elements union other.elements
        return IntegerSet(unionSet)
    }

    // Метод для пересечения множеств
    fun intersection(other: IntegerSet): IntegerSet {
        val intersectionSet = this.elements intersect other.elements
        return IntegerSet(intersectionSet)
    }

    // Переопределяем метод toString для удобного отображения множества
    override fun toString(): String {
        return elements.joinToString(prefix = "{", postfix = "}")
    }
}

fun main() {
    // Примеры использования
    val set1 = IntegerSet(1, 2, 3, 4, 5)
    val set2 = IntegerSet(4, 5, 6, 7, 8)

    println("Множество 1: $set1")
    println("Множество 2: $set2")

    val unionSet = set1.union(set2)
    println("Объединение множеств: $unionSet")

    val intersectionSet = set1.intersection(set2)
    println("Пересечение множеств: $intersectionSet")
}
