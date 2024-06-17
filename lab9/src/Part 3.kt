fun main() {
    val collection = listOf("Banana", "Apple", "Banana", "Cherry", "Apple", "Date")

    val sortedDistinctCollection = collection.distinct().sorted()

    println("Отсортированная коллекция без повторов: $sortedDistinctCollection")
}
