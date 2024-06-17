fun main() {
    val strings = listOf("first", "second", "third", "fourth", "fifth")

    // Получаем третий элемент (индекс 2)
    val thirdElement = strings.drop(2).firstOrNull()

    // Получаем последний элемент
    val lastElement = strings.drop(strings.size - 1).firstOrNull()

    println("Third element: $thirdElement")
    println("Last element: $lastElement")
}