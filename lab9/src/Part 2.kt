fun main() {
    val collection = listOf("Hello123", "World456", "NoDigitsHere", "Another789")
    val pattern = Regex("\\d+")

    val firstElement = collection.firstOrNull()
    val allMatchPattern = collection.all { it.contains(pattern) }

    println("Первый элемент коллекции: $firstElement")
    println("Все ли строки совпадают с шаблоном: $allMatchPattern")
}
